package veteo_LM;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Base_Class {
	public static RequestSpecification httprequest;
	public void requestMethod() {
		RestAssured.baseURI="http://localhost:3000";
		 httprequest=RestAssured.given();
	}

}
