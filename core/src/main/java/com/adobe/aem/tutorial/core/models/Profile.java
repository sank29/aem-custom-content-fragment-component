package com.adobe.aem.tutorial.core.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Profile {
	
	private static final Logger log = LoggerFactory.getLogger(Profile.class);
	
	@Self
	Resource resource;
	
	ProfileData profileData = new ProfileData();
	
	@ValueMapValue
	private String path;

	public String getPath() {
		
		return path;
	}
	
	@PostConstruct
	private void init() {
		
		ResourceResolver resolver = resource.getResourceResolver();
		Session session = resolver.adaptTo(Session.class);

		HashMap<String, String> predicate = new HashMap<>();
		
		predicate.put("path", getPath());
		predicate.put("property", "cq:model");
		predicate.put("property.value", "/conf/practice/settings/dam/cfm/models/player-database");
		
		
		QueryBuilder queryBuilder = resolver.adaptTo(QueryBuilder.class);
		Query query = queryBuilder.createQuery(PredicateGroup.create(predicate), session);
		
		try {
			
			SearchResult searchResult = query.getResult();
			List<Hit> hits = searchResult.getHits();
			
			for(Hit eachHit: hits) {

				Resource parent = eachHit.getResource();
				
				for(Resource eachResource: parent.getChildren()) {
					
					ValueMap data = eachResource.getValueMap();
					
					String image = data.get("profileImageLink", String.class);
					String name = data.get("name", String.class);
					String age = data.get("age", String.class);
					String position = data.get("position", String.class);
					String country = data.get("country", String.class);	
					List<String> clubsPlayed = Arrays.asList(data.get("clubsPlayed", String[].class));				
			
					profileData.setImage(image);
					profileData.setName(name);
					profileData.setPosition(position);
					profileData.setAge(age);
					profileData.setCountry(country);
					profileData.setClubsPlayed(clubsPlayed);

				}
			} 
			
	    } catch (Exception e) {
	        log.error("Index not found for Profile query. Check oak:index configuration.", e);
	        // fallback: set default values to avoid component crash
	    }
		
			
		}
		
	

	public ProfileData getProfileData() {
		return profileData;
	}
	
	

}
