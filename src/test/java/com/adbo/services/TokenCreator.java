package com.adbo.services;
import java.io. IOException;

public interface TokenCreator <T> {
String getBearerToken(T type) throws IOException;
}
