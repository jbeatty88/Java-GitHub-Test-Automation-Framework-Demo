package com.framework.apitest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class Java11GetHeaderTest {
    private static final String BASE_GITHUB_URL = "https://api.github.com/";
    HttpClient httpClient = HttpClient.newBuilder().build();
    HttpResponse<Void> response;
    HttpRequest get;

    @BeforeEach
    void setup() throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_GITHUB_URL))
                .GET()
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
    }

    @AfterEach
    void cleanup() {

    }

    @ParameterizedTest
    @CsvSource({
            "X-Ratelimit-Limit,60",
            "content-type,application/json; charset=utf-8",
            "server,GitHub.com",
            "x-frame-options,deny"
    })
    void parameterizedTestForHeaders(String header, String expectedValue) throws IOException, InterruptedException {
        // Act
        String contentType = response.headers().firstValue(header).get();
        // Assert
        assertEquals(expectedValue, contentType);

    }

    @Test
    void getReturns200() throws IOException, InterruptedException {
        // Act
        int actualCode = response.statusCode();
        // Assert
        assertEquals(200, actualCode);
    }
}
