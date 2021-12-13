package apitest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.specification.RequestSpecification;

public class APIGenSpecs {
	
	public static RequestSpecification auth(String uname, String password) {
		
		RequestSpecification auth = given()
		.auth().basic(uname, password);
		return auth;
		
	}
	
	public static void getHeaderAndBody(String content, String  string) {
//		RequestSpecification header =  
				given()
				.header("Content-Type", content)
				.body(string);	;
//		System.out.println("Header: "+header);
	}
	
	public static void getBody(String  string) {
		
		given().body(string);	
	}
}
