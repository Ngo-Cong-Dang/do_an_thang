package com.example.do_an_thang.domain.dtos;

import com.example.do_an_thang.domain.entities.type.AccountState;
import com.example.do_an_thang.domain.entities.type.AccountType;
import com.example.do_an_thang.domain.entities.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
  private String username;

  private String password;

  private String fullName;

  private String phoneNumber;

  private String email;

  private LocalDateTime confirmedAt;

  private String address;

  private Gender gender;

  private String avatarUrl;

  private AccountState state;

  private AccountType type;
}
