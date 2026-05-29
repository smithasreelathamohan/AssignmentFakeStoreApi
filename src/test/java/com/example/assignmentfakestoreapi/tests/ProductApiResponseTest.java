package com.example.assignmentfakestoreapi.tests;

import com.example.assignmentfakestoreapi.config.APIBase;
import com.example.assignmentfakestoreapi.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

public class ProductApiResponseTest extends APIBase {

    @Test
    public void getProductCountReturns20() {
        List<Product> products = fetchAllProducts();
        assertNotNull(products);
        logger.info("Product count : " + products.size());
        assertEquals(20, products.size());

    }

    @Test
    public void verifyProductDetailByProductID() {
        int productId = 1;
        Product product = fetchProductById(productId);

        logger.info("Product details for Product id "+productId+": " + product);
        assertEquals(1,product.getId());
        assertEquals("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops" ,product.getTitle());
        assertEquals(109.95,product.getPrice());
        assertEquals("men's clothing",product.getCategory());
        assertEquals("Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday", product.getDescription());
        assertEquals("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png", product.getImage());
        logger.info("All fields verified for product ID :" + productId);
    }

}
