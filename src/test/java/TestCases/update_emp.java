package TestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import XLUtiles.ReadUtils;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import veteo_LM.Base_Class;

public class update_emp extends Base_Class{
	public static RequestSpecification httprequest;
	public static Response response;
	String fname=ReadUtils.firstName();
	String Lname=ReadUtils.lastname();
	String subid=ReadUtils.subjectid();
	
			@BeforeClass
 public void update() throws InterruptedException {
		RestAssured.baseURI="http://localhost:3000";
		 httprequest=RestAssured.given();
		JSONObject obj=new JSONObject();
		obj.put("firstname", fname);
		obj.put("lastname", Lname);
		obj.put("subjectId", subid);
		httprequest.header("Content-Type","application/json").contentType("application/json").accept("application/json");
		httprequest.body(obj.toJSONString());
	  response=httprequest.request(Method.PUT, "/users/"+empid);
	//	Thread.sleep(5000);
	 
 }
	@Test
	public void statusCode() {
		int code=response.statusCode();
		Assert.assertEquals(code,200);
		
	}
	@Test
	public void statusline() {
		String Line	=response.statusLine();
		System.out.println(Line);
		Assert.assertEquals(Line, "HTTP/1.1 200 OK");
		
	}
	@Test
	public void  Respondstime() {
	Long time	=response.getTime();
	System.out.println(time);
	Assert.assertTrue(time<2000);
	}
	@Test
	public void verify() {
		Assert.assertEquals(response.body().asString().contains(fname), true);
		Assert.assertEquals(response.body().asString().contains(Lname), true);
		Assert.assertEquals(response.body().asString().contains(subid), true);
	}
	

}
