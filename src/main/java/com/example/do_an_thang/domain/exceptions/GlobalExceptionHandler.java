package com.example.do_an_thang.domain.exceptions;

import com.example.do_an_thang.domain.exceptions.info.BaseException;
import com.example.do_an_thang.domain.exceptions.info.ExceptionResponse;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.NestedServletException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ResourceFoundException.class})
  public ResponseEntity<Object> handleFoundException(
      BaseException exception, WebRequest webRequest) {
    return new ResponseEntity<>(ExceptionResponse.createFrom(exception), HttpStatus.FOUND);
  }

  @ExceptionHandler({AccountNotExistsException.class, ResourceNotFoundException.class})
  public ResponseEntity<Object> handleNotFoundException(
      BaseException exception, WebRequest webRequest) {
    return new ResponseEntity<>(ExceptionResponse.createFrom(exception), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({EmptyResultDataAccessException.class})
  public ResponseEntity<Object> handleNotFoundException(
      Exception exception, WebRequest webRequest) {
    return new ResponseEntity<>(ExceptionResponse.createFrom(exception), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({WrongAccountOrPasswordException.class, UnauthorizedException.class})
  public ResponseEntity<Object> handleUnAuthorizedException(
      BaseException exception, WebRequest webRequest) {
    return new ResponseEntity<>(ExceptionResponse.createFrom(exception), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler({MalformedJwtException.class})
  public ResponseEntity<Object> handleUnAuthorizedException(
      Exception exception, WebRequest webRequest) {
    return new ResponseEntity<>(ExceptionResponse.createFrom(exception), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler({
    NestedServletException.class,
    IllegalStateException.class,
    IllegalStateException.class
  })
  public ResponseEntity<?> handleAllException(Exception exception, WebRequest webRequest) {
    return new ResponseEntity<>(
        ExceptionResponse.createFrom(exception), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler({AccessError.class, BadRequestException.class})
  public ResponseEntity<?> handleBadRequestException(Exception exception, WebRequest webRequest) {
    return new ResponseEntity<>(ExceptionResponse.createFrom(exception), HttpStatus.BAD_REQUEST);
  }
}
