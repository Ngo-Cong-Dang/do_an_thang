package com.example.do_an_thang.domain.dtos;

import com.example.do_an_thang.domain.entities.type.CategoryState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
  @NotNull private String name;

  @NotNull private String imageUrl;

  private String description;

  @NotNull private CategoryState state;

  @NotNull private Integer accountId;
}
