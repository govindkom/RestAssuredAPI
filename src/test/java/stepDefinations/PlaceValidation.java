package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import PoJo.AddPlaceBase;
import PoJo.LocationChild;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.utils;

public class PlaceValidation extends utils {
	RequestSpecification ress;
	ResponseSpecification respspec;
	Response response;
	TestDataBuild data=new TestDataBuild();
	
	JsonPath js;
	static String place_id;
	
	
	
	@Given("Add Place Payload {string}  {string}  {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {

	
		 ress=given().spec(requestSpecifications()).body(data.addPayload(name, language, address));
	}
	
	@When("user calls {string} with {string} http Request")
	public void user_calls_with_http_request(String resource, String method) {
		
		
		APIResources resourceAPI= APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
	
		 respspec=	new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 
		 if(method.equalsIgnoreCase("POST")) {
			 response=	ress.when().post(resourceAPI.getResource());
		 } else if(method.equalsIgnoreCase("GET")) {
			 response=	ress.when().post(resourceAPI.getResource());
		 }
		
				// .then().spec(respspec).extract().response();
	  	}
	
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		
		Assert.assertEquals(response.getStatusCode(),200);
		

	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		
		 
		Assert.assertEquals(getJsonPath(response, keyValue), Expectedvalue);
		
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		 place_id=getJsonPath(response, "place_id");
		 ress=given().spec(requestSpecifications()).queryParam("place_id", place_id);
		 user_calls_with_http_request(resource, "GET");
		 String Actualname=getJsonPath(response, "name");
				 Assert.assertEquals(Actualname, expectedName);

	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws Exception {
	   
given().spec(requestSpecifications()).body(data.deletePlacePayload(place_id));
	}
}
