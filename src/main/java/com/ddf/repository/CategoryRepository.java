package com.ddf.repository;

import com.ddf.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Category findCategoryByName(String productName);
}
