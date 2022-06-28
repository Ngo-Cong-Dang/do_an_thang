package com.example.do_an_thang.domain.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CartProductDTO {
  @NotNull private Integer id;
  @NotNull private Integer amount;
}
