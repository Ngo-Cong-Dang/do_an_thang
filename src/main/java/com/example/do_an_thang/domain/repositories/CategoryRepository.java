package com.example.do_an_thang.domain.repositories;

import com.example.do_an_thang.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
  Category findCategoryById(Integer id);
}
