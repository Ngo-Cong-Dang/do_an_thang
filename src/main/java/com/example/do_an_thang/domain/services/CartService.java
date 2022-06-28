package com.example.do_an_thang.domain.services;

import com.example.do_an_thang.domain.ModelMapper;
import com.example.do_an_thang.domain.dtos.CartProductDTO;
import com.example.do_an_thang.domain.entities.Cart;
import com.example.do_an_thang.domain.repositories.CartRepository;
import com.example.do_an_thang.domain.responses.CartResonse;
import com.example.do_an_thang.domain.utils.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CartService {
  @Autowired private ModelMapper modelMapper;
  @Autowired private CartRepository cartRepository;

  public Cart createCart(CartProductDTO dto, Integer accountId) {
    Cart cart = cartRepository.findCartByAccountId(accountId);
    if (cart == null) {
      cart = new Cart(dto, accountId);
    }
    cart.setProducts(JsonParser.toJson(dto));

    return cartRepository.save(cart);
  }

  public CartResonse findByUserId(Integer accountId) throws IOException {
    Cart cart = cartRepository.findCartByAccountId(accountId);
    if (cart == null) {
      cart = new Cart();
      cart.setAccountId(accountId);
      cart.setProducts("[]");
      return new CartResonse(cart);
    }
    return new CartResonse(cart);
  }
}
