package com.kevin.code.better.common.enums;

import java.util.Objects;

/**
 * 通用枚举
 *
 * @author kevin
 */
public interface BaseEnum<T extends Enum<T> & BaseEnum<T>> {

  /**
   * code
   */
  String getCode();

  /**
   * name
   */
  String getName();


  /**
   * 根据code获取对应的枚举值
   *
   * @param enumClass
   * @param code
   * @param <T>
   */
  static <T extends Enum<T> & BaseEnum<T>> T getByCode(Class<T> enumClass, String code) {
    for (T t : enumClass.getEnumConstants()) {
      if (Objects.equals(code, t.getCode())) {
        return t;
      }
    }
    return null;
  }

}
