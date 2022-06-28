package com.example.do_an_thang.domain.responses;

import com.example.do_an_thang.domain.dtos.CartProductDTO;
import com.example.do_an_thang.domain.entities.Cart;
import com.example.do_an_thang.domain.utils.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResonse {

  private Integer id;

  private List<CartProductDTO> products;

  private Integer accountId;

  public CartResonse(Cart cart) throws IOException {
    id = cart.getId() == null ? 0 : cart.getId();
    products = JsonParser.arrayList(cart.getProducts(), CartProductDTO.class);
    accountId = cart.getAccountId();
  }
}
