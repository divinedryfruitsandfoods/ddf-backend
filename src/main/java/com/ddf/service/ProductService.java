package com.ddf.service;

import com.ddf.domain.entity.Product;
import com.ddf.exception.domain.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product findProductByProductName(String productName);

    Product addNewProduct(String productName, String productImageUrl, String productDescription, int productPrice, String quality, String quantity, String flavour, int weight, String weightType, String form); //throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

    Product updateProduct(String currentProductName, String productImageUrl, String newProductName, String newProductDescription, int newProductPrice, String quality, String quantity, String flavour, int weight, String weightType, String form); // throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

    void deleteProduct(String productName) throws IOException;

    Product updateQuantity(String productName, String quantity);
//    Product updateProductImage(String productName, MultipartFile profileImage); //throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;
}
