package com.kevin.bean.validator.moulder.user.service.impl;

import com.kevin.bean.validator.moulder.user.entity.dto.request.UserRegisterReqDto;
import com.kevin.bean.validator.moulder.user.entity.dto.response.UserRegisterResDto;
import com.kevin.bean.validator.moulder.user.service.UserService;
import com.kevin.code.better.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现
 *
 * @author kevin
 */
@Service
public class UserServiceImpl implements UserService {


  @Override
  public UserRegisterResDto register(UserRegisterReqDto reqDto) {

    //参数校验
    if (reqDto == null) {
      throw new BizException("非法请求");
    }
    if (StringUtils.isBlank(reqDto.getCaptcha())) {
      throw new BizException("验证码不能为空");
    }
    if (StringUtils.isBlank(reqDto.getUserName())) {
      throw new BizException("用户名不能为空");
    }
    if (StringUtils.isBlank(reqDto.getPassword())) {
      throw new BizException("密码不能为空");
    }
    if (!StringUtils.equals(reqDto.getPassword(), reqDto.getRePassword())) {
      throw new BizException("两次输入的密码不一致");
    }
    //......

    //省略业务逻辑...
    UserRegisterResDto resDto = new UserRegisterResDto();
    resDto.setSuccess(true);
    return resDto;
  }
}
