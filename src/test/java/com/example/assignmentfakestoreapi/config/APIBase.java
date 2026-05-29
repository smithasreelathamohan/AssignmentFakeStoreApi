package com.example.assignmentfakestoreapi.config;


import com.example.assignmentfakestoreapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.logging.Logger;

public class APIBase {
    protected static Logger logger = Logger.getLogger(APIBase.class.getName());
    public static final String BASE_URL = "https://fakestoreapi.com/";
    protected static WebClient webClient;

    @BeforeEach
    void setupClass() {
        webClient = WebClient.create(BASE_URL);
        logger.info("Base URL: " + BASE_URL);
    }

    protected List<Product> fetchAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Product>>() {
                })
                .block();
    }

    protected Product fetchProductById(int id) {
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

}
