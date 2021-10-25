package TestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.*;

import com.google.gson.JsonObject;

import XLUtiles.ReadUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import veteo_LM.Base_Class;

public class Create_request {
	public static RequestSpecification httprequest;
	public static  Response response;
	String fname=ReadUtils. firstName() ;
	String lname=ReadUtils. lastname();
	String subid=ReadUtils.subjectid();
	@BeforeClass
	public void CreateUser() throws InterruptedException{
		RestAssured.baseURI="http://localhost:3000";
		 httprequest=RestAssured.given();
		 JSONObject obj=new JSONObject();
		 obj.put( "firstname",fname);
		 obj.put("lastname", lname);
		 obj.put("subjectId", subid);
		 httprequest.header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
		 httprequest.body(obj.toJSONString());
		 response= httprequest.request(Method.POST,"/users");
		 response.then().statusCode(201).log().all();
		 Thread.sleep(5000);
	}
	@Test
	public void validatecreate() {
		String body=response.body().asString();
		//System.out.println(body);
		Assert.assertEquals(body.contains(fname), true);
		Assert.assertEquals(body.contains(lname), true);
		Assert.assertEquals(body.contains(subid), true);
	}
	@Test
	public void statuscode() {
		Assert.assertEquals( response.getStatusCode(), 201);
	}
	@Test
	public void statusline() {
		Assert.assertEquals( response.getStatusLine(), "HTTP/1.1 201 Created");
		
	}
	@Test
	public void content_type() {
		Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
	}
	@Test
	public void ContentLength(){
		Assert.assertEquals(response.header("Content-Length"),"82");
		
	}

}
