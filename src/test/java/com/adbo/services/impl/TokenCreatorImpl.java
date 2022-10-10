package com.adbo.services.impl;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adbo.services.RestClientHandler;
import com.adbo.services.TokenCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adbo.World;
import com.adbo.domain.json.adbo_transformation_coordinator.security.AuthenticationRequestDto;
import com.adbo.domain.json.adbo_transformation_coordinator.security.TokenResponseDetailDto;

import java.util.HashMap;

@Component
public class TokenCreatorImpl implements TokenCreator {

	@Value("${rbs.accesstoken.ur1}")
	private String tokenEndPoint;

	@Autowired
	private World world;

	@Autowired
	RestClientHandler restClient;

	Response response;

	HashMap<String, Object> requestHeaders;

	String brand;

	private static final Logger log = LoggerFactory.getLogger(TokenCreatorImpl.class);

	public String getBearerToken(Object type) {
		AuthenticationRequestDto authenticationRequestDto = (AuthenticationRequestDto) type;
		requestHeaders = new HashMap<>();
		requestHeaders.put("brand", this.brand = world.brand);
		log.info("request headers ->" + authenticationRequestDto.toString());
		response = restClient.post(tokenEndPoint, requestHeaders, authenticationRequestDto.toString(), world.scenario);
		return restClient.mapToBean(TokenResponseDetailDto.class, response).getAccessToken();
	}
}