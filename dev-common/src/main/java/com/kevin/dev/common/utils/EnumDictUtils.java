package com.kevin.dev.common.utils;

import com.kevin.dev.common.enums.BaseEnum;
import com.kevin.dev.common.enums.EnumDict;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public final class EnumDictUtils {

  private EnumDictUtils() {
  }


  public static <T extends Enum<T> & BaseEnum<T>> List<EnumDict> getEnumDicts(Class<T> cls) {
    return EnumSet.allOf(cls)
        .stream()
        .map(et -> new EnumDict(et.getName(), et.getCode()))
        .collect(Collectors.toList());
  }

}
