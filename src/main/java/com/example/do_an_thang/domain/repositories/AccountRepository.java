package com.example.do_an_thang.domain.repositories;

import com.example.do_an_thang.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
  Account findByUsername(String username);

  Account findAccountById(Integer id);
}
