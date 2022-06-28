package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestFailedException extends BaseException {

  public RequestFailedException(String message) {
    super(ErrorCode.REQUEST_ERROR, message);
  }

  public RequestFailedException() {
    super(ErrorCode.REQUEST_ERROR, "Request failed");
  }
}
