package com.adobe.aem.tutorial.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class EmployeeDetails {
	
	@ValueMapValue
	private String name;
	
	@ValueMapValue
	private String age;
	
	@ValueMapValue
	public String phone;
	
	@ValueMapValue
	private String company;
	
	@ValueMapValue
	private String designation;
	
	@ChildResource
	private List<EmployeeListSkills> multifieldList;

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getCompany() {
		return company;
	}

	public String getDesignation() {
		return designation;
	}

	public List<EmployeeListSkills> getMultifieldList() {
		return multifieldList;
	}
	
	

}
