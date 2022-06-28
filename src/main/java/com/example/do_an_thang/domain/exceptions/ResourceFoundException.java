package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;

public class ResourceFoundException extends BaseException {
  public ResourceFoundException() {
    super(ErrorCode.RESOURCE_FOUND, "Resource Found");
  }

  public ResourceFoundException(String message) {
    super(ErrorCode.RESOURCE_FOUND, message);
  }
}
