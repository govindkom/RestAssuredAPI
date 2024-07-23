
Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if place is being Successfully added using AddPlaceAPI

Given Add Place Payload "<name>"  "<language>"  "<address>"
When user calls "AddPlaceAPI" with "post" http Request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "getPlaceAPI"

Examples:
|name   | language |address    					|
|AAhouse|English 	 |	World cross Center|
#|BBHouse|Hindi		|	WTC									|


#Scenario Outline: Verify if place is being Successfully added using AddPlaceAPI
#
#Given Add Place Payload "<name>"  "<language>"  "<address>"
#When user calls "deletePlaceAPI" with "get" http Request
#Then the API call is success with status code 200
#And "status" in response body is "OK"
#And "scope" in response body is "APP"
#
#Examples:
#|name   | language |address    					|
#|AAhouse|English 	 |	World cross Center|
#|BBHouse|Hindi		|	WTC									|


@DeletePlace
Scenario: Verify if Delete Place Functionality is working
Given DeletePlace Payload
When user calls "deletePlaceAPI" with "post" http Request
Then the API call is success with status code 200
And "status" in response body is "OK"
