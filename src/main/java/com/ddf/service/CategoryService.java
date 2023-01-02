package com.ddf.service;

import com.ddf.domain.entity.Category;
import com.ddf.domain.entity.Product;
import com.ddf.exception.domain.CategoryDeleteException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category create(Category category);

    Optional<Category> findCategoryByName(String category_name);

    Category update(Category category);

    void deleteCategory(String category_name) throws CategoryDeleteException;
}
