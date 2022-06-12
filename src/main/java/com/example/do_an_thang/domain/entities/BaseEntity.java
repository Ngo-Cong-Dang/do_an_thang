package com.example.do_an_thang.domain.entities;

import lombok.Data;

import javax.persistence.Column;

@Data
public class BaseEntity {
  @Column(name = "created_at")
  protected Long createdAt;

  @Column(name = "updated_at")
  protected Long updatedAt;
}
