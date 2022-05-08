package com.slodkacysia.bakeryshop.repository;

import com.slodkacysia.bakeryshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(Long id);
    List<Category>findAllBy();
}
