package com.framework.apitest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class Java11PostFails {
    private static final String BASE_GITHUB_URL = "https://api.github.com";
    HttpClient httpClient = HttpClient.newBuilder().build();
    HttpRequest post;
    HttpResponse<Void> response;

    @BeforeEach
    void setup() throws IOException, InterruptedException {
        post = HttpRequest.newBuilder(URI.create(BASE_GITHUB_URL + "user/repos"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        response = httpClient.send(post, HttpResponse.BodyHandlers.discarding());
    }

    @Test
    void postwithoutAuthFail() {
        // Act
        int actualCode = response.statusCode();

        // Assert
        assertEquals(401, actualCode);
    }
}
