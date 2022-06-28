package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;

public class ParamInvalidExcetion extends BaseException {
  public ParamInvalidExcetion() {
    super(ErrorCode.NOT_VALID, "Not valid");
  }

  public ParamInvalidExcetion(String message) {
    super(ErrorCode.NOT_VALID, message);
  }
}
