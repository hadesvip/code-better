package com.kevin.code.better.common.enums;

import java.util.Optional;

/**
 * 通用返回code
 *
 * @author kevin
 */
public enum CodeEnum implements BaseEnum<CodeEnum> {

  /**
   *
   */
  SUCCESS("200", "操作成功"),

  /**
   *
   */
  FAIL("500", "操作失败");

  private final String code;

  private final String desc;

  CodeEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  @Override
  public String getCode() {
    return this.code;
  }

  @Override
  public String getName() {
    return this.desc;
  }

  public static Optional<CodeEnum> of(String code) {
    return Optional.ofNullable(BaseEnum.getByCode(CodeEnum.class, code));
  }

}
