package com.kevin.code.better.common.entity.dto;

import lombok.Data;

/**
 * http 统一返回
 *
 * @author kevin
 */
@Data
public class HttpRt<T> {

  private int code;
  private String message;
  private T data;
  private long timestamp;


  public HttpRt() {
    this.timestamp = System.currentTimeMillis();
  }


  public static <T> HttpRt<T> success(T data) {
    HttpRt<T> httpRt = new HttpRt<>();
    httpRt.setCode(200);
    httpRt.setMessage("处理成功");
    httpRt.setData(data);
    return httpRt;
  }

  public static <T> HttpRt<T> fail(int code, String message) {
    HttpRt<T> httpRt = new HttpRt<>();
    httpRt.setCode(code);
    httpRt.setMessage(message);
    return httpRt;
  }
}
