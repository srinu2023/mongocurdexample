package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
public Product createProduct(Product product);
public Product updateProduct(Product product);
public List<Product> getAllProduct();
public Product getProductById(Long productId);
public void deleteProduct(long productId);
}
