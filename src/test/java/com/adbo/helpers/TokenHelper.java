package com.adbo.helpers;

import java.io. IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adbo.domain.json.adbo_transformation_coordinator.security.AuthenticationRequestDto;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
@Component

public class TokenHelper {

@Value("${rbs.accesstoken.url}")
private String tokenEndPoint;
@Autowired

private World world;

private static final Logger log = LoggerFactory.getLogger(TokenHelper.class) ;

public String getBearerToken(AuthenticationRequestDto authenticationRequestDto) throws IOException {
String token = null;

CloseableHttpClient httpClient = HttpClientBuilder.create().build();

try {

Gson gson = new Gson();

HttpPost request = new HttpPost(tokenEndPoint) ;

StringEntity params = new StringEntity(gson.toJson(authenticationRequestDto) ) ;
request. setHeader("content-type", "application/json");

request. setHeader("brand","nwb");

request.setEntity(params) ;

log.info("Request details "+ gson.toJson(authenticationRequestDto)) ;
log.info("Request URL "+ request.toString());

HttpResponse response = httpClient.execute(request) ;

log.info("Response code "+ response.getStatusLine());

token = new JSONObject(EntityUtils.toString(response.getEntity())).getString("access_token");
log.info("Token details 	"+ token);

response.getEntity();

 

} catch (Exception ex) {

ex.getMessage();

} finally {

}

httpClient.close();

return token;

}}
