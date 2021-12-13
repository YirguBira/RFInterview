package parsejson;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetResource {

	public static void getResource(String url) {
		given()
//				.auth().preemptive().basic(args.get("uname"), args.get("pwd"));	
		.when()
				.get(url)
		.then()
			.assertThat()
				.body("deck_id", equalTo("uog5p9etf5ht"));
				
	}
	
	public static void getValues(String url) {
		
		given()
		.when()
			.get(url)
		.then()
			.assertThat()
				.body("cards[0].images.svg", startsWith("https://deckofcardsapi.com/static/img"));

	}
}
