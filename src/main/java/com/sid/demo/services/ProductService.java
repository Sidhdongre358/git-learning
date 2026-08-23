package com.sid.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.sid.demo.model.Product;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>(List.of(
            new Product(1L, "Laptop", "Electronics", 999.99, true),
            new Product(2L, "Headphones", "Electronics", 149.50, true),
            new Product(3L, "Coffee Maker", "Home", 79.00, false),
            new Product(4L, "Keyboard", "Accessories", 59.99, true),
            new Product(5L, "Mouse", "Accessories", 29.99, true),
            new Product(6L, "Monitor", "Electronics", 199.99, true),
            new Product(7L, "Desk Lamp", "Home", 39.99, true),
            new Product(8L, "USB Cable", "Accessories", 9.99, true),
            new Product(9L, "Smartphone", "Electronics", 699.00, true),
            new Product(10L, "Tablet", "Electronics", 329.00, true),
            new Product(11L, "Webcam", "Electronics", 89.99, true),
            new Product(12L, "Microphone", "Electronics", 129.99, true),
            new Product(13L, "Chair", "Furniture", 149.99, true),
            new Product(14L, "Notebook", "Stationery", 4.99, true),
            new Product(15L, "Pen Set", "Stationery", 12.99, true),
            new Product(16L, "Backpack", "Accessories", 49.99, true),
            new Product(17L, "External HDD", "Electronics", 79.99, true),
            new Product(18L, "SSD", "Electronics", 119.99, true),
            new Product(19L, "Router", "Electronics", 59.99, true),
            new Product(20L, "Bluetooth Speaker", "Electronics", 89.50, true),
            new Product(21L, "Smartwatch", "Electronics", 199.99, true),
            new Product(22L, "Coffee Beans", "Grocery", 15.99, true),
            new Product(23L, "Water Bottle", "Home", 19.99, true),
            new Product(24L, "Electric Kettle", "Home", 49.99, true),
            new Product(25L, "Blender", "Home", 89.99, false),
            new Product(26L, "Printer", "Electronics", 129.99, true),
            new Product(27L, "Cables Organizer", "Accessories", 14.99, true),
            new Product(28L, "HDMI Cable", "Accessories", 12.49, true),
            new Product(29L, "Gaming Mouse", "Electronics", 69.99, true),
            new Product(30L, "Gaming Keyboard", "Electronics", 129.99, true),
            new Product(31L, "Desk", "Furniture", 249.99, true)
    ));

    private final AtomicLong productSequence = new AtomicLong(products.stream()
            .mapToLong(Product::getId)
            .max()
            .orElse(0L));

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public Product createProduct(Product product) {
        if (product == null || product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("Invalid product");
        }

        System.out.println("Creating product: " + product.getName() + ", Category: " + product.getCategory() + ", Price: " + product.getPrice() + ", In Stock: " + product.isInStock());
        Product createdProduct = new Product(
                productSequence.incrementAndGet(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.isInStock()
        );

        products.add(createdProduct);
        return createdProduct;
    }
}
