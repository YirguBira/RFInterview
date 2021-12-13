package parsejson;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ParseJsonObject {
	static String urlSingle = "https://deckofcardsapi.com/api/deck/uog5p9etf5ht";
	static String urlArrays = "https://deckofcardsapi.com/api/deck/new/draw/?count=5";
	static JsonPath jPath = new JsonPath(RestAssured.given().when().get(Run.urlArrays).asString());
	static List<HashMap<String,String>> lmap = jPath.get("cards.images");
	
	public static void main(String[] args) {
		parseWithJsonPath(urlArrays);
		System.out.println(lmap.size());
		iteratesOverEntrySet();
		iterateOverKeySet();
//		parseDeserializeObject(urlArrays);
//		parseDeserializeObject2(urlArrays);
	}
	
	static void parseWithJsonPath(String url){
		JsonPath json = new JsonPath(given().get(url).body().asString());
		Boolean jscol = json.get("success");
		System.out.println("jscol2 value: "+jscol.toString());
		Assert.assertEquals(jscol.equals(true), true);
		
		List<HashMap<String,String>> jscol2 = json.get("cards");
		System.out.println("jscol2 size: "+jscol2.size());
		Assert.assertEquals(jscol2.size(), 5);		 	
	}
	
	static void iteratesOverEntrySet() {
		
		for(HashMap<String,String> key:lmap) {
			//use Entry
			for(Entry<String, String> entry:key.entrySet()) {
//				System.out.println(entry.getKey()+":"+entry.getValue());
				System.out.println(entry.getKey());
			}
		}
	}
	
	static void iterateOverKeySet() {

		for(HashMap<String,String> kSet:lmap) {
			//use keySet
			for(String str:kSet.keySet()) {
					System.out.println(kSet.get(str));
			}
		}
	}
	
	static void parseDeserializeObject(String url) {
		JsonDeserializer jsonD =
				RestAssured.given().when().get(url)
				.jsonPath().getObject("cards.images",JsonDeserializer.class);
		
		System.out.println(jsonD.png.toString());
	}
	static void parseDeserializeObject2(String url) {
		Response response = when().get(url);
		JsonPath jp = new JsonPath(response.body().asString());
		JsonDeserializer jsonD =
				jp.getObject("cards.images",JsonDeserializer.class);		
		System.out.println(jsonD.svg.toString());
	}

}
