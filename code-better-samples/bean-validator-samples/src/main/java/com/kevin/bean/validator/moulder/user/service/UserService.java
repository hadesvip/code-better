package com.kevin.bean.validator.moulder.user.service;

import com.kevin.bean.validator.moulder.user.entity.dto.request.UserRegisterV1ReqDto;
import com.kevin.bean.validator.moulder.user.entity.dto.response.UserRegisterV1ResDto;

/**
 * 用户接口
 *
 * @author kevin
 */
public interface UserService {

  /**
   * 注册
   *
   * @param userRegisterReqDto
   * @return
   */
  UserRegisterV1ResDto register(UserRegisterV1ReqDto userRegisterReqDto);

}
