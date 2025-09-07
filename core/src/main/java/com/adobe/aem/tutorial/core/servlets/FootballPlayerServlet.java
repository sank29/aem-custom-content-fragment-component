/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.tutorial.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class })
@SlingServletResourceTypes( resourceTypes = "practice/components/page", 
							selectors = "query-contentfragment",
							methods = HttpConstants.METHOD_POST,
							extensions = "json")
@ServiceDescription("Simple Demo Servlet")
public class FootballPlayerServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	
	private static JsonObject resourceToJson(Resource resource) {
        JsonObject jsonObject = new JsonObject();

        // Add all properties
        resource.getValueMap().forEach((key, value) -> {
            if (value != null) {
                jsonObject.addProperty(key, value.toString());
            }
        });

        // Add all child nodes
        for (Resource child : resource.getChildren()) {
            jsonObject.add(child.getName(), resourceToJson(child));
        }

        return jsonObject;
    }

	@Override
	protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {

		final Resource resource = req.getResource();
		ResourceResolver resolver = req.getResourceResolver();
		Session session = resolver.adaptTo(Session.class);
		JsonArray jsonArray = new JsonArray();
		
		HashMap<String, String> predicate = new HashMap<>();
		predicate.put("path", "/content/dam/practice/content-fragments");
		predicate.put("type", "dam:Asset");
		predicate.put("property","jcr:content/data/cq:model");
		predicate.put("property.value","/conf/practice/settings/dam/cfm/models/player-database");
		predicate.put("limit", "-1");

		QueryBuilder queryBuilder = resolver.adaptTo(QueryBuilder.class);
		Query query = queryBuilder.createQuery(PredicateGroup.create(predicate), session);
		SearchResult searchResult = query.getResult();
		List<Hit> hits = searchResult.getHits();
		
		for(Hit eachHit: hits) {
			
			try {
				Resource cfResource = eachHit.getResource();
				JsonObject jsonObject = resourceToJson(cfResource);
                jsonArray.add(jsonObject);
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		resp.setContentType("application/json");
		resp.getWriter().write("This are the path where this componet are author on page= " + jsonArray.toString());
	}
}




