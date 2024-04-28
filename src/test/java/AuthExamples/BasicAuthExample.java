package AuthExamples;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthExample {

	@Test
	public void basicAuth() {
		
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://httpbin.org");
		req.basePath("/basic-auth/raghu/raghu123");
		
	//non-preemptive
	//Dont share credentials initially to server, only if any error then credentials will be shared
	
	Response res=req.auth().basic("raghu","raghu123").get();
	System.out.println(res.statusCode());
	
	}
	
	@Test
	public void basicAuthPreemptive() {
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://httpbin.org");
		req.basePath("/basic-auth/raghu/raghu123");
		
		//preemptive - share credentials initially
		Response res=req.auth().preemptive().basic("raghu","raghu123").get();
		System.out.println(res.statusLine());
	}
}
