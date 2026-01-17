package com.adobe.aem.tutorial.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TabComponent {
	
	@Inject
	private List<Resource> multifieldList;
	
	List<TabCard> listOfTabComponent = null;
	
	private static final Logger log = LoggerFactory.getLogger(TabComponent.class);
	
	private static final Gson gson = new GsonBuilder()
		    .disableHtmlEscaping()
		    .create();


	@SuppressWarnings("deprecation")
	@PostConstruct
	private void init() {
		
		listOfTabComponent = new ArrayList<>();
		
		if(multifieldList != null && !multifieldList.isEmpty()) {
			
			for(Resource eachResource: multifieldList) {
				TabCard tabCard = new TabCard();
				ValueMap valueMap = eachResource.getValueMap();
				
				String cardDescription = valueMap.get("cardDescription", String.class);
				String imageLocation = valueMap.get("cardImage", String.class);
				String cardTitle = valueMap.get("cardTitle", String.class);
				String cardPath = valueMap.get("path", String.class);
				
				tabCard.setCardTitle(cardTitle);
				tabCard.setCardDescription(cardDescription);
				tabCard.setImageLocation(imageLocation);;
				tabCard.setPath(cardPath);
				
				listOfTabComponent.add(tabCard);
				
				
				
			}
		}
		
	}

	
	public List<TabCard> getListOfTabComponent() {
		
		return listOfTabComponent;
		
	}
	
	public String getListOfTabComponentJson() {
	    return new Gson().toJson(listOfTabComponent).replace("\\r\\n", "");
	}
	

}
