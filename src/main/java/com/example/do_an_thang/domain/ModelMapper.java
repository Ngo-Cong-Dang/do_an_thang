package com.example.do_an_thang.domain;

import com.example.do_an_thang.domain.dtos.CartProductDTO;
import com.example.do_an_thang.domain.dtos.CategoryDTO;
import com.example.do_an_thang.domain.dtos.CreateUserDTO;
import com.example.do_an_thang.domain.entities.Account;
import com.example.do_an_thang.domain.entities.Cart;
import com.example.do_an_thang.domain.entities.Category;
import com.example.do_an_thang.domain.entities.Product;
import com.example.do_an_thang.domain.responses.HomeProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {
  //  TokenInfo toTokenInfo(UserDetailsImpl userDetails);

  Account toAccount(CreateUserDTO dto);

  Category toCategory(CategoryDTO dto);

  Cart toCart(CartProductDTO dto);

  HomeProductResponse toHomeProductResponse(Product product);
}
