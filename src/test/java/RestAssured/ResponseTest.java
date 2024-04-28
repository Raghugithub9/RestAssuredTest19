package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ResponseTest {

	
	@Test
public void test() {
	RequestSpecification req=RestAssured.given();
	req.baseUri("https://reqres.in");
	req.basePath("/api/users/2");
	
	Response res=req.get();
	System.out.println(res.statusCode());
	System.out.println(res.statusLine());
	
}
	@Test
	public void responsebody() {
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqres.in");
		req.basePath("api/users?page=2");
		Response res=req.get();
		ResponseBody resbody=res.getBody();
		String rs=resbody.asString();
		System.out.println(rs);
		
		JsonPath jsondata=resbody.jsonPath();
		String firstname=jsondata.get("data[1].first_name");
		System.out.println(firstname);
		
		String email=jsondata.get("data[0].email");
		System.out.println(email);
		
		int total=jsondata.get("total");
		System.out.println(total);
		
		
	}
	
	
	
}
