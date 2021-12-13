package apitest;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class Post extends APIGenSpecs{
	
	static Response response;
	static JSONObject json = new JSONObject() ;
	
	public static Response post(String URI) {	
		json.put("id",34);
		json.put("body","some great comment");
		json.put("postId",34);
		response = given().
				header("Content-Type", "application/json")
				.body(json.toJSONString())
				.post(URI);
		System.out.println("Json String: "+json.toJSONString());
		return response;
	}
	
	public static void assertPost() {
		int statCode = response.getStatusCode();
		System.out.println(response.getHeaders());
		System.out.println("Status Code: "+statCode);
		Assert.assertEquals(201, statCode);
	}

}
