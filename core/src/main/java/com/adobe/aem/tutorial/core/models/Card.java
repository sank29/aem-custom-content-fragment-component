package com.adobe.aem.tutorial.core.models;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = Resource.class)
public class Card {
	
	@ValueMapValue
	private String imageLocation;
	
	@ValueMapValue
	private String cardDescription;

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

	@Override
	public String toString() {
		return "Card [imageLocation=" + imageLocation + ", cardDescription=" + cardDescription + "]";
	}
	
	

}
