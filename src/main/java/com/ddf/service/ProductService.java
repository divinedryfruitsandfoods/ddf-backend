package com.ddf.service;

import com.ddf.domain.entity.Product;
import com.ddf.exception.domain.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product register(String productName, String productDescription, int productPrice, String quality, String quantity, String flavour, int weight, String weightType, String form, String createdBy, String updatedBy, String updatedOn); //throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;

    List<Product> getProducts();

    Product findProductByProductName(String productName);

    //User findUserByEmail(String email);

    Product addNewProduct(String productName, String productDescription, int productPrice, String quality, String quantity, String flavour, int weight, String weightType, String form, String createdBy, String updatedBy, String updatedOn); //throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

    Product updateProduct(String currentProductName, String newProductName, String newProductDescription, String newProductPrice, String quality, String quantity, String flavour, int weight, String weightType, String form, MultipartFile profileImage); // throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

    void deleteProduct(String productName) throws IOException;

//    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

    Product updateProductImage(String productName, MultipartFile profileImage); //throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;
}
