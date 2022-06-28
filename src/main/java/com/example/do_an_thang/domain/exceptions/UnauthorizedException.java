package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;

public class UnauthorizedException extends BaseException {
  public UnauthorizedException() {
    super(ErrorCode.UNAUTHORIZED, "Account not found");
  }
}
