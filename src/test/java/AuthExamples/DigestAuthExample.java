package AuthExamples;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DigestAuthExample {

	@Test
public void DigestTest() {
	
	RequestSpecification req=RestAssured.given();
	req.baseUri("https://httpbin.org");
	//req.basePath("/digest-auth/undefined/raghu/test1");
	req.basePath("/digest-auth/undefined/test1/test2");
	Response res=req.auth().digest("test1", "test2").get();
	System.out.println(res.statusCode());
	int stacode=res.statusCode();
	Assert.assertEquals(stacode, 200);
}
	
}
