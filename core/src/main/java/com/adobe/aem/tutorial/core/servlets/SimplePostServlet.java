
package com.adobe.aem.tutorial.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import com.day.cq.commons.jcr.JcrConstants;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class })
@SlingServletResourceTypes(resourceTypes = "practice/components/page", selectors = "aem-tutorial-post", methods = HttpConstants.METHOD_POST, extensions = "txt")
@ServiceDescription("Simple Demo Servlet")
public class SimplePostServlet extends SlingAllMethodsServlet {

	@Reference
	ResourceResolverFactory resourceResolverFactory;

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {

		final Resource resource = req.getResource();
		resp.setContentType("text/plain");
		resp.getWriter().write("Title ,from post Servelt= " + resource.getValueMap().get(JcrConstants.JCR_TITLE));
	}
}
