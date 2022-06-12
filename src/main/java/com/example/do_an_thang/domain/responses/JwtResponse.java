package com.example.do_an_thang.domain.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
  private Boolean isSuccess;
  private String messgage;
  private String token;
  private String refreshToken;

  public JwtResponse() {
    isSuccess = false;
    messgage = "Sai tên đăng nhập hoặc mật khẩu!";
  }

  public JwtResponse(String token) {
    isSuccess = true;
    messgage = "Thành công!";
    this.token = token;
  }
}
