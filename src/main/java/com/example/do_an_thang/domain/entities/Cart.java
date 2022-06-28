package com.example.do_an_thang.domain.entities;

import com.example.do_an_thang.domain.dtos.CartProductDTO;
import com.example.do_an_thang.domain.utils.JsonParser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
public class Cart extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //// TODO: 16/06/2022 jsonParser
  @Column(name = "products")
  private String products;

  @Column(name = "account_id")
  private Integer accountId;

  public Cart(CartProductDTO dto, Integer accountId) {
    products = JsonParser.toJson(dto);
    this.accountId = accountId;
  }
}
