package com.ddf.resource;

import com.ddf.constant.CategoryImplConstant;
import com.ddf.constant.ProductImplConstant;
import com.ddf.domain.HttpResponse;
import com.ddf.domain.entity.Category;
import com.ddf.domain.entity.Product;
import com.ddf.domain.entity.User;
import com.ddf.exception.domain.*;
import com.ddf.service.CategoryService;
import com.ddf.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.ddf.constant.GlobalConstant.PLEASE_CONTACT_ADMIN;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/products"})
public class ProductResource {

    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add_product")
    public ResponseEntity<Product> addNewProduct(@RequestParam("productName") String productName,
                                           @RequestParam("productImageUrl") String productImageUrl,
                                           @RequestParam("productDescription") String productDescription,
                                           @RequestParam("productPrice") int productPrice,
                                           @RequestParam("quality") String quality,
                                           @RequestParam("quantity") String quantity,
                                           @RequestParam("flavour") String flavour,
                                           @RequestParam("weight") int weight,
                                           @RequestParam("weightType") String weightType,
                                           @RequestParam("form") String form) {
        Product newProduct = productService.addNewProduct(productName, productImageUrl, productDescription, productPrice,
                quality, quantity ,flavour, weight, weightType, form);
        return new ResponseEntity<>(newProduct, OK);
    }

    @PutMapping("/update_product")
    public ResponseEntity<Object> updateProduct(@RequestParam("currentProductName") String currentProductName,
                                                @RequestParam("productName") String productName,
                                                @RequestParam("productImageUrl") String productImageUrl,
                                                @RequestParam("productDescription") String productDescription,
                                                @RequestParam("productPrice") int productPrice,
                                                @RequestParam("quality") String quality,
                                                @RequestParam("quantity") String quantity,
                                                @RequestParam("flavour") String flavour,
                                                @RequestParam("weight") int weight,
                                                @RequestParam("weightType") String weightType,
                                                @RequestParam("form") String form) {
        Product updatedProduct = productService.updateProduct(currentProductName, productName, productImageUrl, productDescription, productPrice,
                quality, quantity ,flavour, weight, weightType, form);
        if(updatedProduct == null){
            return new ResponseEntity<>(new HttpResponse(400, HttpStatus.BAD_REQUEST,PLEASE_CONTACT_ADMIN,"NA"),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedProduct, OK);
    }

    @DeleteMapping("/delete/{product_name}")
    public ResponseEntity<HttpResponse> deleteProduct(@PathVariable("productName") String productName) throws IOException, CategoryDeleteException {
        productService.deleteProduct(productName);
        return response(OK, ProductImplConstant.PRODUCT_DELETED_SUCCESSFULLY);
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                message), httpStatus);
    }
}
