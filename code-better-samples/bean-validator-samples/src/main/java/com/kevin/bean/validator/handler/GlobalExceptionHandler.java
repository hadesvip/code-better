package com.kevin.bean.validator.handler;

import com.kevin.code.better.common.entity.dto.HttpRt;
import com.kevin.code.better.common.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author kevin
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


  /**
   * 处理MethodArgumentNotValidException
   *
   * @param e
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public HttpRt<?> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    return HttpRt.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),
        "参数错误" + e.getBindingResult().getAllErrors().get(0).getDefaultMessage());

  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public HttpRt<?> handleException(Exception e) {
    return HttpRt.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统繁忙，请稍后重试。");
  }


  @ExceptionHandler(BizException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public HttpRt<?> handleException(BizException e) {
    return HttpRt.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
  }


}
