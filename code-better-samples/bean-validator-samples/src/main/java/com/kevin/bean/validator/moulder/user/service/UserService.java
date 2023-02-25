package com.kevin.bean.validator.moulder.user.service;

import com.kevin.bean.validator.moulder.user.entity.dto.request.UserRegisterReqDto;
import com.kevin.bean.validator.moulder.user.entity.dto.response.UserRegisterResDto;

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
  UserRegisterResDto register(UserRegisterReqDto userRegisterReqDto);

}
