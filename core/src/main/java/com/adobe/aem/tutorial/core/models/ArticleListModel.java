package com.adobe.aem.tutorial.core.models;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Session;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.adobe.aem.tutorial.core.bean.ArticleListDataBean;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ArticleListModel {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleListModel.class);
	
	@Inject
	private String articleRootPath;
	
	List<ArticleListDataBean> articleListDataBeansArray = null;
	
	@Self
	Resource resource;

	public String getArticleRootPath() {
		return articleRootPath;
	}
	
	@PostConstruct
	private void init() {
		
		ResourceResolver resourceResolver = resource.getResourceResolver();
		Session session = resourceResolver.adaptTo(Session.class);
		QueryBuilder builder = resourceResolver.adaptTo(QueryBuilder.class);
		

		Map<String, String> predicate = new HashMap<>();
		
		predicate.put("path", articleRootPath);
		predicate.put("type", "cq:Page");
		
		Query query = null;
		
		try {
			
			query = builder.createQuery(PredicateGroup.create(predicate), session);
			
		}catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("Error in Query", e);
			
		}
		
		SearchResult searchResult = query.getResult();
		
		articleListDataBeansArray = new ArrayList<>();
		
		for(Hit hit : searchResult.getHits()) {
			
			ArticleListDataBean articleListDataBean = new ArticleListDataBean();
			
			String path = null;
			
			try {
				
				path = hit.getPath();
				Resource articleResource = resourceResolver.getResource(path);
				Page articalPage = articleResource.adaptTo(Page.class);
				String title = articalPage.getTitle();
				String description = articalPage.getDescription();
				
				articleListDataBean.setPath(path);
				articleListDataBean.setTitle(title);
				articleListDataBean.setDescription(description);
				
				articleListDataBeansArray.add(articleListDataBean);
				
				LOGGER.debug("Path:{} \nTitle:{}, \nDescription:{}", path, title, description);
				
				
				
			}catch (Exception e) {
				// TODO: handle exception
				LOGGER.error("Error in Query", e);
			}
			
			
		}
		
		
	}
	
	public List<ArticleListDataBean> getArticleListDataBeansArray(){
		
		return articleListDataBeansArray;
	}
	

}








