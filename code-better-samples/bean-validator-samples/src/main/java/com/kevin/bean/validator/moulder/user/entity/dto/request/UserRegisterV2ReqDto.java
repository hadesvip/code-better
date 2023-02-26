package com.kevin.bean.validator.moulder.user.entity.dto.request;

import lombok.Data;

/**
 * 用户注册请求
 *
 * @author kevin
 */

@Data
public class UserRegisterV2ReqDto {

  /**
   * 用户名
   */
  private String userName;

  /**
   * 密码
   */
  private String password;

  /**
   * 确认密码
   */
  private String rePassword;

  /**
   * 验证码
   */
  private String captcha;

  @Override
  public String toString() {
    return "{" +
        "\"userName\":\"" +
        userName + '\"' +
        ",\"password\":\"" +
        password + '\"' +
        ",\"rePassword\":\"" +
        rePassword + '\"' +
        ",\"captcha\":\"" +
        captcha + '\"' +
        "}";
  }


}
