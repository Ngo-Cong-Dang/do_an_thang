package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountNotExistsException extends BaseException {
  public AccountNotExistsException() {
    super(ErrorCode.ACCOUNT_NOT_EXISTS, "Account not found");
  }

  public AccountNotExistsException(String message) {
    super(ErrorCode.ACCOUNT_NOT_EXISTS, message);
  }
}
