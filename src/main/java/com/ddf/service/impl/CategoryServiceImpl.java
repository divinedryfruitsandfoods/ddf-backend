package com.ddf.service.impl;

import com.ddf.domain.entity.Category;
import com.ddf.exception.domain.CategoryDeleteException;
import com.ddf.repository.CategoryRepository;
import com.ddf.service.CategoryService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static com.ddf.constant.CategoryImplConstant.CATEGORY_FOLDER;
import static com.ddf.constant.FileConstant.DEFAULT_CATEGORY_IMAGE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category create(Category category) {
        category.setCategoryImageUrl(getTemporaryCategoryImageUrl(category.getCategoryName()));
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByCategoryName(categoryName);
    }

    @Override
    public Category update(Category category) {
        Optional<Category> byId = categoryRepository.findById(category.getId());
        Category updateCategory = null;
        if(byId.isPresent()){
            updateCategory = byId.get();
            updateCategory.setCategoryName(category.getCategoryName());
            updateCategory.setSubCategoryName(category.getSubCategoryName());
            categoryRepository.save(updateCategory);
        }
        return updateCategory;
    }

    @Override
    public void deleteCategory(String categoryName) throws CategoryDeleteException {
        Optional<Category> category = categoryRepository.findCategoryByCategoryName(categoryName);
        if(category.isPresent()){
            Path userFolder = Paths.get(CATEGORY_FOLDER + category.get().getCategoryName()).toAbsolutePath().normalize();
            try {
                FileUtils.deleteDirectory(new File(userFolder.toString()));
            } catch (Exception e) {
                throw new CategoryDeleteException("Error while deleting category");
            }
            categoryRepository.deleteById(category.get().getId());
        }else{

        }
;
    }

    private String getTemporaryCategoryImageUrl(String category_name) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(DEFAULT_CATEGORY_IMAGE_PATH + category_name).toUriString();
    }
}
