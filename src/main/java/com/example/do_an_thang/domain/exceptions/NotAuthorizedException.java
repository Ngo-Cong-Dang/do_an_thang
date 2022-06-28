package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException extends BaseException {
  private static final long serialVersionUID = 1L;

  public NotAuthorizedException() {
    super(ErrorCode.UNAUTHORIZED, "not authorized");
  }

  public NotAuthorizedException(String message) {
    super(ErrorCode.UNAUTHORIZED, message);
  }
}
