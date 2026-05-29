package com.example.assignmentfakestoreapi.tests;

import com.example.assignmentfakestoreapi.config.APIBase;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductApiStructureTest extends APIBase {

    @Test
    public void testProductApiStructure() {
        var response = webClient.get()
                .uri("/products/2")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        assertNotNull(response);
        logger.info("************************");
        logger.info(response.toString());

        assertTrue(response.containsKey("id"));
        assertTrue(response.containsKey("title"));
        assertTrue(response.containsKey("price"));
        assertTrue(response.containsKey("description"));
        assertTrue(response.containsKey("category"));
        assertTrue(response.containsKey("image"));

    }
}
