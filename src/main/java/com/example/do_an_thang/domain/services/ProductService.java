package com.example.do_an_thang.domain.services;

import com.example.do_an_thang.domain.ModelMapper;
import com.example.do_an_thang.domain.entities.Product;
import com.example.do_an_thang.domain.repositories.ProductRepository;
import com.example.do_an_thang.domain.responses.HomeProductResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ProductService {
  @Autowired private ProductRepository productRepository;
  @Autowired private ModelMapper modelMapper;
  //    private

  public List<HomeProductResponse> findNewProduct() {
    List<HomeProductResponse> homeProductResponses = new ArrayList<>();
    List<Product> products = productRepository.findByIsHot(4);
    if (products != null) {
      for (Product product : products) {
        HomeProductResponse homeProductResponse = modelMapper.toHomeProductResponse(product);
        homeProductResponse.setPrice(product.getPrice() - product.getDiscount());
        homeProductResponses.add(homeProductResponse);
      }
    }
    return homeProductResponses;
  }
}
