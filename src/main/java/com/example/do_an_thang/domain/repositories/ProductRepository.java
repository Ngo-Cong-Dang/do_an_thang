package com.example.do_an_thang.domain.repositories;

import com.example.do_an_thang.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  Product findProductById(Integer id);

  List<Product> findByCategoryId(Integer categoryId);

  @Query(
      nativeQuery = true,
      value = "select * from product p where p.is_hot ORDER BY RAND() limit :limit")
  List<Product> findByIsHot(@Param("limit") Integer limit);
}
