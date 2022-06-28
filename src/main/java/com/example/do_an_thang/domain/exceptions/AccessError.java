package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;

public class AccessError extends BaseException {
  private static final long serialVersionUID = 1L;

  public AccessError(String exception) {
    super(ErrorCode.ACCESS_ERROR, exception);
  }
}
