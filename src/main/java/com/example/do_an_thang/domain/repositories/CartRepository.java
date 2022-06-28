package com.example.do_an_thang.domain.repositories;

import com.example.do_an_thang.domain.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
  Cart findCartByAccountId(Integer accountId);
}
