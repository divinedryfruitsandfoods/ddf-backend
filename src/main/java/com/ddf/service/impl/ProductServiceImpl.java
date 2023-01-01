package com.ddf.service.impl;

import com.ddf.domain.entity.Product;
import com.ddf.repository.ProductRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl
{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product buildProduct(String productName, String productDescription, int productPrice, int weight)
    {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);
        product.setWeight(weight);
        return product;
    }


    public List<Product> getProducts() {
        return null;
    }


    public Product findProductByProductName(String productName) {
        return null;
    }


    public Product addNewProduct(String productName, String productDescription, int productPrice, String quality, String quantity, String flavour, int weight) {
        return null;
    }


    public Product updateProduct(String currentProductName, String newProductName, String newProductDescription, String newProductPrice, String quality, String quantity, String flavour, int weight, MultipartFile profileImage) {
        return null;
    }


    public void deleteProduct(String productName) throws IOException {

    }


    public Product updateProductImage(String productName, MultipartFile profileImage) {
        return null;
    }
}
