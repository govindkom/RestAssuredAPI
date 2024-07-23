package resources;

public enum APIResources {
	
	//enum is special type of class in java which has collection of constants or methods
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	// constructor will called with the value of resource which you pass
	
	private String resource;
	
	APIResources(String  resource){
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
}
