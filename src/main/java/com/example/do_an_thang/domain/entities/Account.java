package com.example.do_an_thang.domain.entities;

import com.example.do_an_thang.domain.dtos.AccountUpdateDTO;
import com.example.do_an_thang.domain.entities.type.AccountState;
import com.example.do_an_thang.domain.entities.type.AccountType;
import com.example.do_an_thang.domain.entities.type.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
@NoArgsConstructor
public class Account extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "phone")
  private String phoneNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "address")
  private String address;

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(name = "avatar_url")
  private String avatarUrl;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private AccountState state;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private AccountType type;

  public void from(AccountUpdateDTO dto) {
    fullName = dto.getFullName();

    phoneNumber =
        dto.getPhoneNumber() == null
            ? phoneNumber == null ? null : phoneNumber
            : dto.getPhoneNumber();

    address = dto.getPhoneNumber() == null ? address == null ? null : address : dto.getAddress();

    gender = dto.getPhoneNumber() == null ? gender == null ? null : gender : dto.getGender();

    avatarUrl =
        dto.getPhoneNumber() == null ? avatarUrl == null ? null : avatarUrl : dto.getAvatarUrl();
  }
}
