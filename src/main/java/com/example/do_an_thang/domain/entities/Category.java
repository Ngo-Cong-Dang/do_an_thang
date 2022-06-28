package com.example.do_an_thang.domain.entities;

import com.example.do_an_thang.domain.entities.type.CategoryState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "description")
  private String description;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private CategoryState state;
}
