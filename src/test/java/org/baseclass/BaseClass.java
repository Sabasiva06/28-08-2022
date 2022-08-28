package org.baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification reqSpec;
	Response response;

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}

	public void addBody(Object obj) {
		reqSpec = reqSpec.body(obj);
	}

	public void methodType(String methodType, String url) throws Exception {
		switch (methodType) {
		case "GET":
			response = reqSpec.log().all().get(url);
			break;
		case "POST":
			response = reqSpec.log().all().post(url);
			break;
		case "PUT":
			response = reqSpec.log().all().put(url);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(url);
			break;
		case "PATCH":
			response = reqSpec.log().all().patch(url);
			break;

		default:
			throw new Exception("Invalid method type");
		}
	}

	public int getResponseCode() {
		return response.getStatusCode();
	}

	public ResponseBody getReponseBody() {
		return response.getBody();
	}
}
