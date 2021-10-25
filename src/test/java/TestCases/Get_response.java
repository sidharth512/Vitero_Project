package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import veteo_LM.Base_Class;

public class Get_response extends Base_Class{
	public RequestSpecification httprequest;
public 	Response responds;
	
@BeforeClass
public void setRequest() throws InterruptedException {
	RestAssured.baseURI="http://localhost:3000/";
    httprequest=RestAssured.given();
     responds=httprequest.request(Method.GET,"/users/"+empid);
    Thread.sleep(5000);
   responds.then().statusCode(200).log().all();
}
@Test
public void id() {
	String id =responds.asString();
	Assert.assertEquals(id.contains(id), true);
	System.out.println(id);
}
@Test
public void statusCode() {
	int code=responds.statusCode();
	Assert.assertEquals(code, 200);
}
@Test
public void statusline() {
	String line=responds.statusLine();
	Assert.assertEquals(line, "HTTP/1.1 200 OK");
}
@Test
public void Responsetime() {
	long  responsetime	=responds.getTime();
	Assert.assertTrue(responsetime<7000);
}
@Test
public void contenttype() {
	String content=responds.header("Content-Type");
	Assert.assertEquals(content.contains("application/json; charset=utf-8"),true);
}

}
