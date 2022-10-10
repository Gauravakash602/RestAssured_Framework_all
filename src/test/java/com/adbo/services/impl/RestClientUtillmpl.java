package com.adbo.services.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import groovy.util.logging.Slf4j;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;

@Component
@Slf4j
public class RestClientUtillmpl implements RestClientHandler {

// RequestSpecification requestSpecification;

//

//

// — @0verride

// public void setBaseUri(String baseUr1) {
// Ws requestSpecification = given();

// W requestSpecification.baseUri(baseUrl) ;
// t

	@Value("${spring.profiles.active:}")
	public String activeProfile;

	/* http get request with url */
	public Response get(String endPoint, Scenario scenario) {
		Response response;
		this.attachRequestDetails("GET", endPoint, scenario);
		response = RestAssured.given().request().accept(ContentType.JSON).relaxedHTTPSValidation().when().get(endPoint)
				.thenReturn();
		this.attachResponseData(response.asString(), scenario);
		return response;
	}

	/* http get request with url and request headers */
	public Response get(String endPoint, HashMap<String, Object> headers, Scenario scenario) {
		Response response;
		activeProfile = getActiveProfile();
		switch (activeProfile.toLowerCase()) {
		case "uat":
			ProxySpecification proxySpecification = new ProxySpecification("userproxy.rbsgrp.net", 8080, "http");
			this.attachRequestDetails("GET", endPoint, headers, scenario);
			response = RestAssured.given().request()
					// .proxy(proxySpecification.withAuth("natarmh", "Eaddudaav1"))
					.proxy(proxySpecification.withAuth("WillRbb", "Sedadunno5")).accept(ContentType.JSON)
					.relaxedHTTPSValidation().when().headers(headers).get(endPoint).thenReturn();
			this.attachResponseData(response.asString(), scenario);
			break;
		default:
			response = RestAssured.given().request().accept(ContentType.JSON).relaxedHTTPSValidation().when()
					.headers(headers).get(endPoint).thenReturn();
			this.attachResponseData(response.asString(), scenario);
			break;
		}
		return response;
	}

	/**
    * This method handles the difference  of retriveing activeProfile
    * when 	running in debug  mode versus  running a maven goal
    * @return activeProfile
    * @author 	
    */




	private String getActiveProfile() {
		String sActiveProfile = System.getProperty("${spring.profiles.active:}");
		if (sActiveProfile==null|| sActiveProfile.isEmpty()){
		sActiveProfile = System.getProperty("spring.profiles.active");
	
		("PARAMETER 2 = "+sActiveProfile);
		
		}
		return sActiveProfile;

		}

	/* http post request with url and request headers */
	public Response post(String endPoint, HashMap<String, Object> requestHeaders, Scenario scenario) {
		Response response;
		this.attachRequestDetails("POST", endPoint, requestHeaders, scenario);
		response = RestAssured.given().request().accept(ContentType.JSON).relaxedHTTPSValidation().when()
				.headers(requestHeaders).post(endPoint).thenReturn();
		this.attachResponseData(response.asString(), scenario);
		return response;
	}

	/* http post request with url and string request body */
	public Response post(String endPoint, String requestBody, Scenario scenario) {
		Response response;

		this.attachRequestDetailsWithBody("POST", endPoint, requestBody, scenario);
		response = given()

				.request()

				.accept(ContentType.JSON)

				.relaxedHTTPSValidation()

				.when()

				.post(endPoint, requestBody).thenReturn();
		this.attachResponseData(response.asString(), scenario);
	}

	public Response post(String endPoint, HashMap<String, Object> headers, String requestBody, Scenario scenario) {
		Response response;
		this.attachRequestDetailsWithBody("POST", endPoint, requestBody, scenario);
		response = given()
		.request()
		.accept("application/json\r\n")
		.pelaxedHTTPSValidation()
		.when()
		sheader("Content.Type", "application/json")
		headers (headers)
		. body(requestBody)
		.post(endPoint)
		.thenReturn();
		this.attachResponseData(response.asString(), scenario);
		return response;

		}

	/* http post request with url and string request body and request headers */
	public Response post(String endPoint, HashMap<String, Object> headers, Object requestBody, Scenario scenario, String sEnvironment) {
		Response response;
		this. attachRequestDetailsWithBody("POST", endPoint, requestBody, scenario);
		ProxySpecification proxySpecification = new ProxySpecification("userproxy.rbsgrp.net", 8080, "http");

		switch(sEnvironment.toLowerCase()) {
		case "uat™:
		response = given()
		.request()
		.proxy(proxySpecification.withAuth("WillRbb", "SedadunnoS"))
		accept ("application/json\r\n")
		pelaxedHTTPSValidation()
		.when()
		sheader("Content.Type", "application/json")
		.headers (headers)
		. body(requestBody)
		.post(endPoint)
		.thenReturn();
		break;
		default:
		response = given()

				.request()
				.accept("application/json\r\n")
				.relaxedHTTPSValidation()
				.when()
				.header("Content.Type", "application/json")
				.headers(headers)
				 .body (requestBody)
				.post(endPoint)
				.thenReturn();

				break;

				}

				this. attachResponseData(response.asString(), scenario);
				return response;

	}

	/* http post request with url and json request body */
	public Response post(String endPoint, JSONObject requestBody, Scenario scenario) {
				Response response;
				this.attachRequestDetailsWithBody("POST", endPoint, requestBody, scenario);
				response = given()
				.request()
				.accept(ContentType. JSON)
				.relaxedHTTPSValidation()
				.when()
				sheader("Content.Type", "application/json")
				. body(requestBody)
				.post(endPoint)
				.thenReturn();
				this.attachResponseData(response.asString(), scenario);
				return response;

				}

	public Response post(String endPoint, HashMap<String, Object> headers, Object requestBody, Scenario scenario) {
		Response response;
		this.attachRequestDetailsWithBody("POST", endPoint, requestBody, scenario);
		response = given().request().accept(ContentType.JSON).relaxedHTTPSValidation()

				.when()

				.headers(headers)

				.body(requestBody)

				.post(endPoint)

				.thenReturn();
		this.attachResponseData(response.asString(), scenario);
		return response;

	}

	/* http put request with url and string request body and request headers */
	public Response put(String endPoint, HashMap<String, Object> headers, String requestBody, Scenario scenario) {
				Response response;
				this. attachRequestDetailswWithBody("PUT", endPoint, requestBody, scenario);
				response = given()
				.request()
				.accept(ContentType. JSON)
				pelaxedHTTPSValidation()
				.when()
				headers (headers)
				. body(requestBody)
				.put(endPoint)
				. thenReturn();
				this. attachResponseData(response.asString(), scenario);
				return response;

				}

	/* http put request with url and json request body */
	public Response put(String endPoint, JSONObject requestBody, Scenario scenario) {
				Response response;
				this.attachRequestDetailsWithBody("PUT", endPoint, requestBody, scenario);
				response = given()
				.request()
				.accept(ContentType. JSON)
				relaxedHTTPSValidation()
				.when()
				. body(requestBody)
				.put (endPoint)
				.thenReturn();
				this. attachResponseData(response.asString(), scenario);	
				return response;
		}

	/* http put request with url and hashmap request body */
	public Response put(String endPoint, HashMap<String, Object> requestBody, Scenario scenario) {
		Response response;
		this.attachRequestDetailsWithBody("PUT", endPoint, requestBody, scenario);
		response = given().request().accept(ContentType.JSON).relaxedHTTPSValidation().when().body(requestBody)
				.put(endPoint).thenReturn();
		this.attachResponseData(response.asString(), scenario);
		return response;
	}

	/* java generic method for mapping api response to beans */
	public <T> T mapToBean(Class<T> beanClass, Response response) {
	try {
	ObjectMapper mapper;
	mapper = new ObjectMapper();
	return mapper.readValue(response.asString(), beanClass);
	} catch (Exception e) {
	log.error("unable to map the response to bean class", e);
	return null;

	}

	/* java generic method for mapping api response to beans */
	public <T> T mapToBean(TypeReference<T> beanClass, Response response) {
	try {
	ObjectMapper mapper;
	mapper = new ObjectMapper();
	return mapper.readValue(response.asString(), beanClass);
	} catch (Exception e) {
	log.error("unable to map the response to bean class", e);
	return null;
	}

	/* java generic method for mapping custom api response to beans */
	public <T> T mapToBean(String response, Class<T> beanClass) {
	try {
	ObjectMapper mapper;
	mapper = new ObjectMapper();
	return mapper.readValue(response, beanClass);
	} catch (Exception e) {
	log.error("unable to map the response to bean class", e);
	return null;

	}

	/* java generic method for mapping mock response from json file to beans */
	public <T> T getMockJsonResponse(String fileName, Class<T> beanClass) {
	try {
	return new Gson().fromJson(new InputStreamReader(new ClassPathResource(fileName).getInputStream()), beanClass);
	} catch (Exception e) {
	log.error("unable to map the mock response to bean class", e);
	return null;

	}

	public void attachResponseData(String response, Scenario scenario) {
		log.info("api response ---->" + response);
		scenario.attach(response, "application/json", "Response Data");

	}

	public void attachRequestDetails(String method, String URL, Scenario scenario) {
		URL = method + " " + URL;
		scenario.attach(URL, "text/plain", "Request URL");

	}

	public void attachRequestDetails(String method, String URL, HashMap<String, Object> headers, Scenario scenario) {
		URL = method + " " + URL;
		scenario.attach(URL, "text/plain", "Request URL");
		scenario.attach(headers.toString(), "text/plain", "Request Headers");
		log.info("Request URL --> " + URL);
		log.info("Request Headers --> " + headers.toString());

	}

	public void attachRequestDetails(String method, String URL, Map<String, Object> headers, Scenario scenario) {
		URL = method +" " + URL;
		scenario.attach(URL, "text/plain", "Request URL");
		scenario.attach(headers.toString(), "text/plain", "Request Headers");

		}

	public void attachRequestDetailsWithBody(String method, String URL, String requestBody, Scenario scenario) {
		URL = method + " " + URL;
		scenario.attach(URL, "text/plain", "Request URL");
		scenario.attach(requestBody, "application/json", "Request Body");

		}

	public void attachRequestDetailswWithBody(String method, String URL, JSONObject requestBody, Scenario scenario) {
		URL = method +" " + URL;
		scenario.attach(URL, "text/plain", "Request URL");
		scenario.attach(requestBody.toString(), "application/json", "Request Body");

		}

	public void attachRequestDetailswWithBody(String method, String URL, Object requestBody, Scenario scenario) {
		URL = method +" " + URL;
		scenario.attach(URL, "text/plain", "Request URL");
		scenario.attach(requestBody.toString(), "application/json", "Request Body");

		}

	public void attachRequestDetailswWithBody(String method, String URL, HashMap<String, Object> requestBody, Scenario scenario) {
		URL = method + " " + URL;
		scenario.attach(URL, "text/plain", "Request URL");
		scenario.attach(requestBody.toString(), "application/json", "Request Body");
	}
	
}