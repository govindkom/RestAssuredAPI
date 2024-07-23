package resources;

import java.util.ArrayList;
import java.util.List;

import PoJo.AddPlaceBase;
import PoJo.LocationChild;

public class TestDataBuild {

	
	public AddPlaceBase addPayload(String name, String language, String address) {
AddPlaceBase p = new AddPlaceBase();
		
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setName(name);
		p.setWebsite("http://google.com");
		
		// to provide values in Array we have to craete arraylist and then need to add that like below
		List<String> myList= new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);
		
		// for Location we have to create class for Location liuke below and then we can use it
		
		LocationChild lo=new LocationChild();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		p.setLocation(lo);
		
		return p;
	}
	
	public String deletePlacePayload(String place_id) {

		return "{\r\n  \"place_id\": \""+place_id+"\"\r\n}";
	}
}
