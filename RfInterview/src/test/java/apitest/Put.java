package apitest;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.junit.Assert;
import io.restassured.response.Response;

public class Put extends APIGenSpecs{
	
	static Response response;
	static JSONObject json = new JSONObject() ;
	
	public static Response put(String URI) {	
		json.put("id",33);
		json.put("body","some nasty comment");
		json.put("postId",32);
		response = given().
				header("Content-Type", "application/json")
				.body(json.toJSONString())
				.put(URI);
		System.out.println("Json String: "+json.toJSONString());
		return response;
	}
	
	public static void assertPut() {
		int statCode = response.getStatusCode();
		System.out.println(response.getHeaders());
		System.out.println("Status Code: "+statCode);
		Assert.assertEquals(200, statCode);
	}

}
