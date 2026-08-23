package com.sid.demo.controller;

import com.sid.demo.model.Product;
import org.junit.jupiter.api.Test;

import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductControllerTest {

    @Test
    public void getProducts_returnsAll() {
        ProductController controller = new ProductController();
        List<Product> products = controller.getProducts();
        assertEquals(31, products.size());
    }

    @Test
    public void getProductById_returnsProduct() {
        ProductController controller = new ProductController();
        ResponseEntity<Product> resp = controller.getProductById(1L);
        assertEquals(200, resp.getStatusCode().value());
        assertNotNull(resp.getBody());
        assertEquals("Laptop", resp.getBody().getName());
    }

    @Test
    public void createProduct_returnsCreated() {
        ProductController controller = new ProductController();
        Product p = new Product(null, "Test Product", "Test", 1.23, true);
        ResponseEntity<Product> resp = controller.createProduct(p);
        assertEquals(201, resp.getStatusCode().value());
        assertNotNull(resp.getBody());
        assertEquals(32L, resp.getBody().getId());
        assertEquals("Test Product", resp.getBody().getName());
    }
}
