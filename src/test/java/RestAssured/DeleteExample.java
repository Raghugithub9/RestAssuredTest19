package RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteExample {

	
	@Test
	public void deleteAPI() {

		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON)
		.when()
			.delete()
		.then()
			.statusCode(204)
			.log().all()
			.header("Server", "cloudflare");
			
		
		
	}
	
	
	
}
