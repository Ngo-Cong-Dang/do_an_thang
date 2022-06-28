package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ErrorCode;

public class PromotionException extends BaseException {
  public PromotionException() {
    super(ErrorCode.ERROR_PROMOTION, "Error date promotion ");
  }

  public PromotionException(String message) {
    super(ErrorCode.ERROR_PROMOTION, message);
  }
}
