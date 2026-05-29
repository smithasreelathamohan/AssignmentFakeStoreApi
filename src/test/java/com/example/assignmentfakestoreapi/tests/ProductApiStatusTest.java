package com.example.assignmentfakestoreapi.tests;

import com.example.assignmentfakestoreapi.config.APIBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductApiStatusTest extends APIBase {

    @Test
    public void getProductReturnsStatusCode200() {

        var response = webClient
                .get()
                .uri("/products")
                .exchangeToMono(r -> r.toEntity(String.class))
                .block();

        if (response == null){
            throw new AssertionError("Response is null");
        }

        logger.info("Received response: " + response.getStatusCode().value());
        assertEquals(200, response.getStatusCode().value(), "Status code is not correct");
    }

    @Test
    public void getSingleProductReturnsStatusCode200() {

        var response = webClient
                .get()
                .uri("/products/5")
                .exchangeToMono(r -> r.toEntity(String.class))
                .block();

        if (response == null){
            throw new AssertionError("Response is null");
        }

        logger.info("Received response: " + response.getStatusCode().value());
        logger.info("Received response: " + response.getBody());
        assertEquals(200, response.getStatusCode().value(), "Status code is not correct");
    }
}
