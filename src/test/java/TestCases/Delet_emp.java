package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delet_emp {
	@Test
	public void setup() {
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httprequest =RestAssured.given();
		Response  responds	=httprequest.request(Method.GET,"http://localhost:3000/users");      
		JsonPath jsonpathevaluator=responds.jsonPath();
	//String empid=	jsonpathevaluator.get("[0].id");
	httprequest.request(Method.DELETE,"/users/14");
//	responds.then().statusCode(200).log().all();
		
	}
	

}
