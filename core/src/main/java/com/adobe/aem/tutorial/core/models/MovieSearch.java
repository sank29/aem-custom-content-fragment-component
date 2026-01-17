package com.adobe.aem.tutorial.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MovieSearch {
	
	
	@ValueMapValue
	private String movieName;
	
	@ValueMapValue
	private String topPadding;
	
	@ValueMapValue
	private String bottomPadding;
	
	@ValueMapValue
	private String leftPadding;
	
	@ValueMapValue
	private String rightPadding;
	
	@ValueMapValue
	private String option;
	

	
	public String getMovieName() {
		return movieName;
	}


	public String getTopPadding() {
		return topPadding;
	}


	public String getBottomPadding() {
		return bottomPadding;
	}


	public String getLeftPadding() {
		return leftPadding;
	}


	public String getRightPadding() {
		return rightPadding;
	}


	public String getOption() {
		return option;
	}

	
	
}
