package com.adobe.aem.tutorial.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class})
public class SecondComponentModel {
	
	@ScriptVariable
	private ResourceResolver resolver;
	
	@SlingObject
	private ResourceResolver resourceResolver;
	
	
	@Default(values = "This is default value")
	@ValueMapValue
	private String title;
	
	@ValueMapValue
	private String text;
	
	@ValueMapValue
	private String eyebrow;
	
	@ValueMapValue
	private String header;

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getEyebrow() {
		return eyebrow;
	}

	public String getHeader() {
		return header;
	}

}






