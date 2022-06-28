package com.example.do_an_thang.domain.services;

import com.example.do_an_thang.domain.ModelMapper;
import com.example.do_an_thang.domain.dtos.CategoryDTO;
import com.example.do_an_thang.domain.entities.Category;
import com.example.do_an_thang.domain.exceptions.ResourceNotFoundException;
import com.example.do_an_thang.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
  @Autowired private CategoryRepository categoryRepository;
  @Autowired private ModelMapper modelMapper;

  public Category createCategory(CategoryDTO dto) {
    Category category = modelMapper.toCategory(dto);
    return categoryRepository.save(category);
  }

  public Category updateCategory(CategoryDTO dto, Integer id) {

    Category category = categoryRepository.findCategoryById(id);

    if (category == null) {
      throw new ResourceNotFoundException("Category không tồn tại!");
    }

    category = modelMapper.toCategory(dto);
    return categoryRepository.save(category);
  }

  public void deleteCategory(Integer id) {

    Category category = categoryRepository.findCategoryById(id);

    if (category == null) {
      throw new ResourceNotFoundException("Category không tồn tại!");
    }

    categoryRepository.delete(category);
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Integer id) {
    Category category = categoryRepository.findCategoryById(id);
    if (category == null) {
      throw new ResourceNotFoundException("Không tồn tại loại hàng này!");
    }
    return category;
  }
}
