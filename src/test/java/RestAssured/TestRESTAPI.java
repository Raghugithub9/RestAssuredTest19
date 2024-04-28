package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestRESTAPI {

	
	@Test
	public void testListUsersAPI() {
		
		Response res=RestAssured.get("https://reqres.in/api/users/2");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getHeader("Server"));
		
		
		int actCode=res.getStatusCode();
		Assert.assertEquals(actCode, 200);
		
	}
	
	
	@Test
	public void testAPI() {
		
		RequestSpecification req=RestAssured.given();
		
		req.baseUri("https://reqres.in");
		req.basePath("/api/users/2");//End point
		
		Response res=req.get();
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		
		
		ResponseBody rb=res.getBody();
		System.out.println(rb.asString());
		
		
		
	}
	
	
	
	
	
	
	
	
}
