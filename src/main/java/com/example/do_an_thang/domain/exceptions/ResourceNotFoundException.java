package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;

public class ResourceNotFoundException extends BaseException {

  public ResourceNotFoundException() {
    super(ErrorCode.RESOURCE_NOT_FOUND, "Resource Not Found");
  }

  public ResourceNotFoundException(String message) {
    super(ErrorCode.RESOURCE_NOT_FOUND, message);
  }
}
