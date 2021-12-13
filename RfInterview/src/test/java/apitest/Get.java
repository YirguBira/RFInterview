package apitest;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

import io.restassured.response.Response;

public class Get extends APIGenSpecs{
	
	static Response response;
	
	public static void getSpecification(String uname, String pwd, String url) {		
		auth(uname, pwd);		
	}
	
	public static Response get(String url) {		
		return response = when().get(url);		
	}
	
	public static void assertGet() {
		int statCode = response.getStatusCode();
		System.out.println(response.getHeaders());
		System.out.println("Status Code: "+statCode);
		Assert.assertEquals(statCode, 200);
	}

}
