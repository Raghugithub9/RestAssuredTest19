package AuthExamples;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth2Example {

	public String accessToken;
	
	@Test
	public void getAccessToken() {
		
		String clientid="AQjbOYUOFCqAVkftquouQn7KP1rRRpmp2_2RMYp2W8_hXqGjwTRA2iuly11yMjWaYdEUrv_J6WhbKr9Y";
		String secretid="EMe81AJ9dVdQq8Jx23vNaqvyuKEdHgkptX9kqiBbdxbl-gJ8ulbiquBiT9s4lbc5exR-AKTCCNbWKRiV";
		
RequestSpecification req=RestAssured.given();
		
		req.baseUri("https://api-m.sandbox.paypal.com");
		req.basePath("/v1/oauth2/token");//End point
		
		Response res=req.auth().preemptive().basic(clientid, secretid).param("grant_type", "client_credentials").post();
		
		System.out.println(res.statusLine());
		System.out.println(res.prettyPrint());
		
		accessToken=res.getBody().path("access_token");
		System.out.println(accessToken);
		
	}
	
	//https://api-m.sandbox.paypal.com/v1/invoicing/invoices?page=3&page_size=4&total_count_required=true\

		 
	
	@Test(dependsOnMethods="getAccessToken")
	public void oAuthTest() {
		
		Response res=(Response) RestAssured
							.given()
								.auth()
									.oauth2(accessToken)
										.queryParam("page", 3)
										.queryParam("page_size", 4)
										.queryParam("total_count_required", "true")
										.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
		
		
		System.out.println(res.statusLine());
		
		
		
		
	}
	
	
	
	
	
	
}
