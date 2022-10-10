package com.adbo.runners;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import okhttp3.OkHttpClient;

import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.http.WebSocket;
import org.openqa.selenium.remote.http.WebSocket.Listener;
import org.junit.Assert;

import java.util.List;
import java.util.function.Supplier;
import java.io.UncheckedIOException;
import java.net.URL;

public class MyHttpClientFactory implements HttpClient.Factory{

    final OkHttpClient okHttpClient;
    
    public MyHttpClientFactory(OkHttpClient okHttpClient) {
    	this.okHttpClient= okHttpClient;
    }


@Override
public HttpClient createClient(URL url) {
	return (HttpClient) okHttpClient;
}


@Override
public void cleanupIdleClients() {
	// TODO Auto-generated method stub
	
}


@Override
public HttpClient createClient(ClientConfig config) {
	// TODO Auto-generated method stub
	return null;
}
}