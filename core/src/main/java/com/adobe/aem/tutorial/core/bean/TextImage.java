package com.adobe.aem.tutorial.core.bean;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class TextImage {
	
	@ValueMapValue
	private String cardDescription;
	
	@ValueMapValue
	private String cardImage;
	
	@ValueMapValue
	private String cardTitle;
	
	@ValueMapValue
	private String path;

	public String getCardDescription() {
		return cardDescription;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public String getCardImage() {
		return cardImage;
	}

	public void setCardImage(String cardImage) {
		this.cardImage = cardImage;
	}

	public String getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "TextImage [cardDescription=" + cardDescription + ", cardImage=" + cardImage + ", cardTitle=" + cardTitle
				+ ", path=" + path + "]";
	}
	
	
	

}
