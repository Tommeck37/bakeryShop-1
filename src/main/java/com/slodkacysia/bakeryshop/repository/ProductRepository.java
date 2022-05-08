package com.slodkacysia.bakeryshop.repository;

import com.slodkacysia.bakeryshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllBy();

    Product findProductById(Long id);

    Product save(Product product);

//    void update(Product product);
//
//    void delete(long productId);

    List<Product> getAllProductByCategory(String category);


}
