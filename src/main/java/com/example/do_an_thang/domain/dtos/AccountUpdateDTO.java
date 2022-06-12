package com.example.do_an_thang.domain.dtos;

import com.example.do_an_thang.domain.entities.type.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class AccountUpdateDTO {
  @NotNull private String fullName;

  private String phoneNumber;

  private String address;

  private Gender gender;

  private String avatarUrl;
}
