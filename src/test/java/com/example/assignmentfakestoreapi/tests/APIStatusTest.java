package com.example.assignmentfakestoreapi.tests;

import com.example.assignmentfakestoreapi.config.APIConstants;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class APIStatusTest extends APIConstants {

    @Test
    public void getProductReturnsStatusCode200() {
        WebClient client = WebClient.create(APIConstants.BASE_URL);

        var response = client
                .get()
                .uri("/products")
                .exchangeToMono(r -> r.toEntity(String.class))
                .block();

        if (response == null){
            throw new AssertionError("Response is null");
        }

        assertEquals(200, response.getStatusCode().value(), "Status code is not correct");
    }
}
