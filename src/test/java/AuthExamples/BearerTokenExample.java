package AuthExamples;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerTokenExample {

	
	@Test
public void BarerTest() {
		
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://gorest.co.in");
		req.basePath("/public/v2/users");

		JSONObject reqpayload=new JSONObject();
		reqpayload.put("email", "Prasad123@gmail.com");
		reqpayload.put("name", "Prasad234");
		reqpayload.put("gender", "male");
		reqpayload.put("status", "Active");
		
		String token="Bearer b11579f91073f384aac01fe8142a1a76291f49980c1adf8c8036aeb949e3cee5";
		
	req.headers("Authorization",token).contentType(ContentType.JSON).body(reqpayload.toJSONString());
	
	Response res=req.post();
	
	System.out.println(res.statusCode());
	
	
	
}
}
