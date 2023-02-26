package com.kevin.code.better.common.entity;

import java.util.Map;
import java.util.Map.Entry;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 验证结果
 *
 * @author kevin
 */
@Data
public class ValidationRt {

  private boolean hasErrors = false;


  private Map<String, String> errorMsg;

  /**
   * 获取一条错误消息
   */
  public String getErrorMessageOneway() {
    if (this.errorMsg == null || this.errorMsg.isEmpty()) {
      return StringUtils.EMPTY;
    }
    Entry<String, String> entry = this.errorMsg.entrySet().iterator().next();
    return entry.getValue();
  }

  @Override
  public String toString() {
    return "{"
        + "\"hasErrors\":"
        + hasErrors
        + ",\"errorMsg\":"
        + errorMsg
        + '}';
  }
}
