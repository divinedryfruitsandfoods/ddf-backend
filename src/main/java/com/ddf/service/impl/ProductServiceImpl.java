package com.ddf.service.impl;

import com.ddf.domain.entity.Product;
import com.ddf.repository.ProductRepository;
import com.ddf.service.ProductService;
import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product buildProduct(String productName, String productImageUrl, String productDescription, int productPrice, String quality, String quantity, String flavour, int weight, String weightType, String form)
    {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductImageUrl(productImageUrl);
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);
        product.setWeight(weight);
        product.setQuality(quality);
        product.setQuantity(quantity);
        product.setFlavour(flavour);
        product.setWeight(weight);
        product.setWeightType(weightType);
        product.setForm(form);
        return product;
    }


    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product findProductByProductName(String productName) {
        return productRepository.findProductByProductName(productName);
    }

    @Override
    public Product addNewProduct(String productName, String productImageUrl, String productDescription, int productPrice, String quality, String quantity, String flavour, int weight, String weightType, String form) {
        Product product = buildProduct(productName, productImageUrl, productDescription, productPrice, quality, quantity, flavour, weight, weightType, form);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(String currentProductName, String productImageUrl ,String newProductName, String newProductDescription, int productPrice, String quality, String quantity, String flavour, int weight, String weightType, String form) {
        Product product = buildProduct(newProductName, productImageUrl, newProductDescription, productPrice, quality, quantity, flavour, weight, weightType, form);
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(String productName) throws IOException {
        Product product = productRepository.findProductByProductName(productName);
        productRepository.deleteById(product.getId());
    }

    @Override
    public Product updateQuantity(String productName, String quantity) {
        Product product = productRepository.findProductByProductName(productName);
        product.setQuantity(quantity);
        productRepository.save(product);
        return product;
    }


}
