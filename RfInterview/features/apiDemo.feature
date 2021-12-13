Feature: Rest API
	As a user I want to send request to the 
	server so that I can receive response
	that fulfils my request

Scenario: Validate server returns response to get request
Given user has "get" request specification
When user sends "get" request to the endpoint
Then server sends back "get" status code to the user

Scenario: Validate server returns response to post request
Given user has "post" request specification
When user sends "post" request to the endpoint
Then server sends back "post" status code to the user

Scenario: Validate server returns response to put request
Given user has "put" request specification
When user sends "put" request to the endpoint
Then server sends back "put" status code to the user
#
Scenario: Validate server returns response to delete request
Given user has "delete" request specification
When user sends "delete" request to the endpoint
Then server sends back "delete" status code to the user