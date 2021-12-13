package apitest;

import cucumber.api.java.en.*;
import io.restassured.response.Response;


public class APIStepDefs {
	
	static Response response;
	
	@Given("user has {string} request specification")
	public void user_has_request_specification(String reqSpec) throws Exception {	    
		APIGenSpecs.auth("", "");
	}

	@When("user sends {string} request to the endpoint")
	public void user_sends_request_to_the_endpoint(String request) throws Exception {
	    
		switch(request) {
		case "get":
			response = Get.get("http://localhost:3000/comments");
			break;
		case "post":
			response = Post.post("http://localhost:3000/comments");
			break;
		case "put":
			response = Put.put("http://localhost:3000/comments/34");
			break;
		case "delete":
			response = Delete.delete("http://localhost:3000/comments/33");
			break;
		default:
			throw new Exception("...Case Not Defined...");
		}
		
	}

	@Then("server sends back {string} status code to the user")
	public void server_sends_back_status_code_to_the_user(String resp) throws Exception {
	    
		switch(resp) {
		case "get":
			Get.assertGet();
			break;
		case "post":
			Post.assertPost();
			break;
		case "put":
			Put.assertPut();
			break;
		case "delete":
			Delete.assertDelete();
			break;
		default:
			throw new Exception("...Case Not Defined...");
		}
	}

}
