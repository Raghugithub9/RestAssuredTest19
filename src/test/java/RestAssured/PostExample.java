package RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostExample {

	
	@Test
	public void postTest() {
		
		JSONObject json=new JSONObject();
		json.put("name", "RestAssured");
		json.put("job", "Automation Tester");
		
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RestAssured
					.given()
						.header("Content-Type","application/json").contentType(ContentType.JSON).body(json.toJSONString())
					.when()
						.post()
					.then()
						.statusCode(201)
						.log().all();
				
		
	}
	
	
}
