package com.framework.apitest;

import com.testframwork.entities.User;
import com.testframwork.handlers.JsonBodyHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class Java11GetBodyTest {

    private static final String BASE_GITHUB_URL = "https://api.github.com/";

    @Test
    void bodyContainsCurrentUserUrl() throws IOException, InterruptedException {
        // Arrange - Create client
        HttpClient httpClient = HttpClient.newBuilder().build();

        // Arrange - create request
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_GITHUB_URL + "users/jbeatty88"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        // Act - Send request
        HttpResponse<User> response = httpClient.send(get, JsonBodyHandler.jsonBodyHandler(User.class));
        String actualLogin = response.body().getLogin();

        // Assert
        assertEquals("jbeatty88", actualLogin);

    }
}
