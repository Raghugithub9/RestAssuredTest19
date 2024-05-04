package AuthExamples;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryParameterExample {

	
	@Test
	public void QueryParamTest() {
		
		RequestSpecification req=RestAssured.given();
		
		req.baseUri("https://reqres.in");
		req.basePath("/api/users");//End point
		
		req.queryParam("page", 3);
		
		
		QueryableRequestSpecification qryrequest=SpecificationQuerier.query(req);
		
		
		//get base URI
		String retrieveBaseURI=qryrequest.getBaseUri();
		System.out.println(retrieveBaseURI);
		
		//get base Path
		String retriveBasePath=qryrequest.getBasePath();
		System.out.println(retriveBasePath);
		
	
		Response res=req.get();
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		
		
		ResponseBody rb=res.getBody();
		System.out.println(rb.asString());
		
		
		
	}
	
}
