package com.adbo.helpers;

import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import io.restassured.http.Header;

import io.restassured.response.Response;

import io.restassured.response.ResponseOptions;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Component

public class RestAssuredExtension {
	public static RequestSpecification Request;
	public static ResponseSpecification Response;

static{

//Logger getLogs=new Logger();

//getLogs.logRequest();

//getLogs.logResponse();
RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
}
public RestAssuredExtension() {
//Arrange
RequestSpecBuilder builder = new RequestSpecBuilder();
builder. setBaseUri("http://localhost:4999/");
builder. setContentType(ContentType. JSON) ;

RequestSpecification requestSpec = builder.build();
Request = RestAssured.given().spec(requestSpec);
}
public static void responseCheckForAll(){
ResponseSpecBuilder builder = new ResponseSpecBuilder();
}

public static ResponseOptions<io.restassured.response.Response> getOpsWithPathParamAndMultipleHeaders(String url, Map<String,String> headerParams , Map<String, String> pathParams){
Request. pathParams(pathParams) ;
/*for (Map.Entry<String,String> header :headerParams.entrySet()){
Request.header(new Header(header.getKey() ,header.getValue() ));}*/

headerParams.forEach((k,v)-> {Request.header(new Header(k,v));});
return Request.get(url);}

public static void getOpsWithPathParameter(String url, Map<String, String> pathParams) {

Request.pathParams(pathParams) ;
try {
Request.get(new URI(url));
} catch (URISyntaxException e) {
e.printStackTrace();
}

}

public static ResponseOptions<Response> getOps(String url) {
try {
return Request.get(new URI(url));
} catch (URISyntaxException e) {
e.printStackTrace();
}

return null;

}

public static ResponseOptions<Response> putOpsWithBodyAndPathParams (String url, Map<String, String> pathParam, Map<String, String> body) {
Request. pathParams(pathParam) ;
Request . body(body) ;
return Request.put(url);

}

public static ResponseOptions<Response> getOpsQueryParams (String url, String queryParams) {

Request. queryParam(queryParams) ;
try {
return Request.get(new URI(url));
} catch (URISyntaxException e) {
e.printStackTrace();
}

return null;
}

public static ResponseOptions<Response> postOpshithBodyAndPathParams (String url, Map<String, String> pathParam, Map<String, String> body) {
Request.pathParams(pathParam) ;
Request.body (body) ;
return Request.post((url));

}



public static ResponseOptions<Response> postOpslithMultipleHeadersAndBody(String url, Map<String,String> headerParams , String body){
//Request.pathParams(pathParams) ;

/*for (Map.Entry<String,String> header :headerParams.entrySet()){
Request.header(new Header(header.getKey(),header.getValue() ));

}*/
headerParams.forEach((k,v)-> {Request.header(new Header(k,v));});
Request . body (body) ;
return Request. post(url);

}

public static ResponseOptions<Response> postOpsWithUrl(String url) {
return Request.post(url);
}



 

public static ResponseOptions<Response> postOpsWithBodyAndPathParamsWithToken(String url, String token, Map<String, String> pathParam, Map<String, String> body) {
Request .header(new Header("x-authorization", token));
Request. pathParams(pathParam) ;
Request . body (body) ;
return Request.post((url));

}

public static ResponseOptions<Response> postOpsWithBody(String url, Map<String, String> body) {
Request.header(new Header("Content-Type", "application/json;charset=utf-8"));
Request . body (body) ;
return Request.post(url);

}

public static ResponseOptions<Response> postOpsWithBody(String url, String body) {
Request.header(new Header("Content-Type", "application/json;charset=utf-8"));
Request. body (body) ;
//Request.given().post(url).then().1og().a11();
return Request.post(url);

}

public static ResponseOptions<Response> postOpsWithBodyAndHeader(String url, String body) {
Request.header(new Header("Content-Type", "application/json;charset=utf-8"));
Request. body(body) ;
return Request.post(url);

}

public static ResponseOptions<Response> deleteOpsWithPathParams (String url, Map<String, String> pathParams) {
Request.pathParams(pathParams) ;
return Request.delete(url);

}

public static ResponseOptions<Response> getWithPathParams(String url, Map<String, String> pathParams) {
Request. pathParams(pathParams) ;
return Request.get(url);

}

public static ResponseOptions<Response> getOpsWithToken(String url, String token) {
Request.header(new Header("x-authorization", token));
return Request.get(url);
}}	

