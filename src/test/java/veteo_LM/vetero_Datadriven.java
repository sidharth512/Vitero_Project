package veteo_LM;


import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import XLUtiles.Read_TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.*;

public class vetero_Datadriven {
	@Test(dataProvider = "userdataprovider")
	public void data_driven(String firstname,String lastname,String subid) {
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httprequest	=RestAssured.given();
		JSONObject request=new JSONObject();
		request.put( "firstname",firstname);
		request.put("lastname", lastname);
		request.put("subjectId", subid);
		  httprequest.header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
		  httprequest.body(request.toJSONString());
		  Response responds  =httprequest.request(Method.POST,"http://localhost:3000/users");
		  responds.then().statusCode(201).log().all();
		  String body=responds.getBody().asString();
		  Assert.assertEquals(body.contains(firstname), true);
		  Assert.assertEquals(body.contains(lastname), true);
		  Assert.assertEquals(body.contains(subid), true);
		  int code=responds.statusCode();
	        System.out.println(code);
		  
		
		
	}
	@DataProvider(name="userdataprovider")
	String [][]	userdata() throws IOException{
		String path="C:\\Users\\User 1\\Desktop\\ecplics\\API_Testing\\src\\test\\java\\UtiliesData\\New Microsoft Office Excel Worksheet (2).xlsx";
		
		int rownum=Read_TestData.getrow(path, "Sheet1");
		int colnum=Read_TestData.getcell(path,"Sheet1", rownum);
		String userData [][]=new String [rownum][colnum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				 userData [i-1][j]=Read_TestData.getcellvalue(path, "Sheet1", i, j);
			}
		}
		return(userData);
		
	}

}
