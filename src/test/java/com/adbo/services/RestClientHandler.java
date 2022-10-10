
package com.adbo.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.java.Scenario;

import io.restassured.response.Response;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public interface RestClientHandler {

	Response get(String endPoint, Scenario scenario);

	Response get(String endPoint, HashMap<String, Object> headers, Scenario scenario);

	Response post(String endPoint, HashMap<String, Object> requestHeaders, Scenario scenario);

	Response post(String endPoint, String requestBody, Scenario scenario);

	Response post(String endPoint, HashMap<String, Object> headers, String requestBody, Scenario scenario);

	Response post(String endPoint, JSONObject requestBody, Scenario scenario);

	Response post(String endPoint, HashMap<String, Object> headers, Object requestBody, Scenario scenario);

	Response post(String endPoint, HashMap<String, Object> headers, Object requestBody, Scenario scenario,
			String environment);

	Response put(String endPoint, HashMap<String, Object> headers, String requestBody, Scenario scenario);

	Response put(String endPoint, JSONObject requestBody, Scenario scenario);

	Response put(String endPoint, HashMap<String, Object> requestBody, Scenario scenario);

	<T> T mapToBean(Class<T> beanClass, Response response);

	<T> T mapToBean(TypeReference<T> beanClass, Response response);

	<T> T mapToBean(String response, Class<T> beanClass);

	<T> T getMockJsonResponse(String fileName, Class<T> beanClass);

	void attachResponseData(String response, Scenario scenario);

	void attachRequestDetails(String method, String URL, Scenario scenario);

	void attachRequestDetails(String method, String URL, HashMap<String, Object> headers, Scenario scenario);

	void attachRequestDetails(String method, String URL, Map<String, Object> headers, Scenario scenario);

	void attachRequestDetailsWithBody(String method, String URL, String requestBody, Scenario scenario);

	void attachRequestDetailsWithBody(String method, String URL, JSONObject requestBody, Scenario scenario);

	void attachRequestDetailsWithBody(String method, String URL, Object requestBody, Scenario scenario);

	void attachRequestDetailsWithBody(String method, String URL, HashMap<String, Object> requestBody,
			Scenario scenario);
}