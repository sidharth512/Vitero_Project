package veteo_LM;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Vetro_Class extends Base_Class  {
	public static RequestSpecification httprequest;
	@Test
	
	public void setup() {
		RestAssured.baseURI="http://localhost:3000";
		 httprequest=RestAssured.given();
	httprequest.param( "firstname", "sidharth");
	Response response=httprequest.request(Method.GET,"/users");
	int code=response.statusCode();
	Assert.assertEquals(code,200);
	response.then().statusCode(200).log().all();
	
}
//	@Test
	public void test_post() {
		RestAssured.baseURI="http://localhost:3000";
		httprequest=RestAssured.given();
		JSONObject obj=new JSONObject();
		obj.put("firstname","Tom");
		obj.put("lastname", "cruse");
		obj.put("subjectId", 1);
		
		httprequest.header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
		httprequest.body(obj.toJSONString());
		Response 	response=httprequest.request(Method.POST,"http://localhost:3000/users");
		response.then().statusCode(201).log().all();
		
	}
	//@Test
	public void test_patch() {
		RestAssured.baseURI="http://localhost:3000";
		httprequest=RestAssured.given();
		JSONObject json= new JSONObject();
		json.put("firstname", "smith");
		json.put("lastname", "stiven");	
		httprequest.header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
		httprequest.body(json.toJSONString());
		Response 	response=httprequest.request(Method.PATCH,"http://localhost:3000/users/4");
		response.then().statusCode(200).log().all();
		
	}
//	@Test
	public void test_put() {
		
		RestAssured.baseURI="http://localhost:3000";
		httprequest=RestAssured.given();
		JSONObject json=new JSONObject();
		json.put("firstname","Tomi");
		json.put("lastname", "cruser");
		json.put("subjectId", 1);
		
		httprequest.header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
		httprequest.body(json.toJSONString());
		Response 	response=httprequest.request(Method.PUT,"http://localhost:3000/users/4");
		response.then().statusCode(200).log().all();
		
		
		
	}
}