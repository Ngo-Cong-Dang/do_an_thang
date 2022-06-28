package com.example.do_an_thang.domain.data;

import com.example.do_an_thang.domain.entities.type.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenInfo {
  private Integer id;
  private String username;
  private AccountType type;
}
