package com.example.do_an_thang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class DoAnThangApplication {

  public static void main(String[] args) {
    SpringApplication.run(DoAnThangApplication.class, args);
  }
}
