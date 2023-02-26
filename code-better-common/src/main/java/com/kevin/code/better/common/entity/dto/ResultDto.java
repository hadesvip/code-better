package com.kevin.code.better.common.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.kevin.code.better.common.enums.CodeEnum;
import java.util.Objects;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
@Data
public class ResultDto<T> {

  private Integer code;

  private String msg;

  private T data;

  public ResultDto(CodeEnum codeEnum) {
    this.code = Integer.valueOf(codeEnum.getCode());
    this.msg = codeEnum.getName();
  }

  public ResultDto(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public ResultDto(CodeEnum rspCode, String msg) {
    this.code = Integer.valueOf(rspCode.getCode());
    this.msg = msg;
  }

  public ResultDto<T> setResult(CodeEnum rspCode) {
    this.code = Integer.valueOf(rspCode.getCode());
    this.msg = rspCode.getName();
    return this;
  }

  public ResultDto<T> setResult(CodeEnum rspCode, String msg) {
    this.code = Integer.valueOf(rspCode.getCode());
    this.msg = msg;
    return this;
  }

  @JSONField(serialize = false, deserialize = false)
  public boolean isSuccess() {
    return Objects.equals(Integer.valueOf(CodeEnum.SUCCESS.getCode()), code);
  }

  public static <T> ResultDto<T> success() {
    return new ResultDto<>(CodeEnum.SUCCESS, CodeEnum.SUCCESS.getName());
  }

  public static <T> ResultDto<T> success(T data) {
    ResultDto<T> result = new ResultDto<>(CodeEnum.SUCCESS, CodeEnum.SUCCESS.getName());
    result.setData(data);
    return result;
  }

  public static <T> ResultDto<T> fail(String message) {
    return new ResultDto<>(CodeEnum.FAIL, message);
  }

  public static <T> ResultDto<T> fail(CodeEnum rspCode, String message) {
    return new ResultDto<>(rspCode, message);
  }

  public static <T> ResultDto<T> fail(CodeEnum rspCode) {
    return new ResultDto<>(rspCode, rspCode.getName());
  }


}
