package com.adobe.aem.tutorial.core.models;

import java.util.List;

public class ProfileData {
	
	private String image;
	private String name;
	private String age;
	private String club;
	private String country;
	private String position;
	private List<String> clubsPlayed;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public List<String> getClubsPlayed() {
		return clubsPlayed;
	}
	public void setClubsPlayed(List<String> clubsPlayed) {
		this.clubsPlayed = clubsPlayed;
	}
	
	
	
	

}
