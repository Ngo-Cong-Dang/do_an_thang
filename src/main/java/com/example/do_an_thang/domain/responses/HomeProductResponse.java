package com.example.do_an_thang.domain.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeProductResponse {
  private Integer id;

  private String name;

  private String imageUrls;

  private String description;

  private Float price;
}
