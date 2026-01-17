package com.adobe.aem.tutorial.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.tutorial.core.bean.ImageText;
import com.adobe.aem.tutorial.core.bean.TextImage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageTextTextImage {
	
	@Self
    private Resource resource;


    private static final Logger log =
            LoggerFactory.getLogger(ImageTextTextImage.class);
    
    @ValueMapValue
    private String cardDescriptionImageText;
    
    @ValueMapValue
    private String cardImageImageText;
    
    @ValueMapValue
    private String cardTitleImageText;
    
    @ValueMapValue
    private String pathImageText;
    
    
    @ValueMapValue
    private String cardDescriptionTextImage;
    
    @ValueMapValue
    private String cardImageTextImage;
    
    @ValueMapValue
    private String cardTitleTextImage;
    
    @ValueMapValue
    private String pathTextImage;
    
    ImageText imageText = new ImageText();
    
    TextImage textImage = new TextImage();

	@PostConstruct
    protected void init() {
		
		imageText.setCardDescription(cardDescriptionImageText);
		imageText.setCardImage(cardImageImageText);
		imageText.setCardTitle(cardTitleImageText);
		imageText.setPath(pathImageText);
	
		textImage.setCardDescription(cardDescriptionTextImage);
		textImage.setCardImage(cardImageTextImage);
		textImage.setCardTitle(cardTitleTextImage);
		textImage.setPath(pathTextImage);
		
	    log.info("cardDescription direct10: {}", imageText.toString());
	    log.info("cardDescription direct20: {}", textImage.toString());

    }

	public String getImageText() {
		
		return new Gson().toJson(imageText).replace("\\r\\n", "");
	}

	public String getTextImage() {
		return new Gson().toJson(textImage).replace("\\r\\n", "");
	}
	
	
	
	

}
