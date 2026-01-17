package com.adobe.aem.tutorial.core.models;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = Resource.class)
public class TabCard {
	
	@ValueMapValue
	private String imageLocation;
	
	@ValueMapValue
	private String cardDescription;
	
	@ValueMapValue
	private String cardTitle;
	
	@ValueMapValue
	private String path;

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}

	@Override
	public String toString() {
		return "Card [imageLocation=" + imageLocation + ", cardDescription=" + cardDescription + "]";
	}
	
	

}
