package PoJo;

import java.util.List;

public class AddPlaceBase {
	
	
	// this is base class to craete getter and setters method to create json objectes
	
	// variables are by default private
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private LocationChild location;
	private List<String>types;
	
	
	
	
	
	// getters ans setters mehtod
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String string) {
		this.phone_number = string;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	public LocationChild getLocation() {
		return location;
	}
	public void setLocation(LocationChild location) {
		this.location = location;
	}
	
	
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	
}
