package com.adobe.aem.tutorial.core.models;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CardComponent {
	
	@Inject
	private List<Resource> multifieldList;
	
	private static final Logger log = LoggerFactory.getLogger(CardComponent.class);
	
	List<Card> listOfCardComponent = null;
	
	@ValueMapValue
	private String testingData;
	
	

	@PostConstruct
	private void init() {
		
		listOfCardComponent = new ArrayList<>();
		
		if(! multifieldList.isEmpty()) {
			
			for(Resource eachResource: multifieldList) {
				Card card = new Card();
				ValueMap valueMap = eachResource.getValueMap();
				
				String cardDescription = valueMap.get("cardDescription", String.class);
				String imageLocation = valueMap.get("cardImage", String.class);
				
				card.setCardDescription(cardDescription);
				card.setImageLocation(imageLocation);;
				
				listOfCardComponent.add(card);
				
			}
			
		}
		
		log.info("Final Result------------------------->: {}", listOfCardComponent);
		
	}

	
	
	public String getTestingData() {
		return testingData;
	}


	public List<Card> getListOfCardComponent() {
		return listOfCardComponent;
	}

	
}
