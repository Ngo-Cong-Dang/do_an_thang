package com.example.do_an_thang.domain.entities;

import com.example.do_an_thang.domain.entities.type.ProductState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  // todo JsonParser
  @Column(name = "image_urls")
  private String imageUrls;

  @Column(name = "description")
  private String description;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private ProductState state;

  @Column(name = "category_id")
  private Integer categoryId;

  @Column(name = "is_hot")
  private Boolean isHot;

  @Column(name = "price")
  private Float price;

  @Column(name = "discount")
  private Float discount;
}
