package com.ddf.resource;

import com.ddf.constant.CategoryImplConstant;
import com.ddf.domain.HttpResponse;
import com.ddf.domain.entity.Category;
import com.ddf.exception.domain.CategoryDeleteException;
import com.ddf.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.ddf.constant.GlobalConstant.PLEASE_CONTACT_ADMIN;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/categories"})
public class CategoryResource {

    private CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create_category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category cat = categoryService.create(category);
        return new ResponseEntity<>(cat, OK);
    }

    @PutMapping("/update_category")
    public ResponseEntity<Object> updateCategory(@RequestBody Category category){
        Category cat = categoryService.update(category);
        if(cat == null){
            return new ResponseEntity<>(new HttpResponse(400, HttpStatus.BAD_REQUEST,PLEASE_CONTACT_ADMIN,"NA"),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cat, OK);
    }

    @DeleteMapping("/delete/{category_name}")
    public ResponseEntity<HttpResponse> deleteUser(@PathVariable("categoryName") String categoryName) throws IOException, CategoryDeleteException {
        categoryService.deleteCategory(categoryName);
        return response(OK, CategoryImplConstant.CATEGORY_DELETED_SUCCESSFULLY);
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                message), httpStatus);
    }
}
