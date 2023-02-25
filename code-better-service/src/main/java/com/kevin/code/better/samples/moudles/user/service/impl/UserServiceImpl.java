package com.kevin.code.better.samples.moudles.user.service.impl;

import com.kevin.code.better.samples.moudles.user.domain.bo.UserBO;
import com.kevin.code.better.samples.moudles.user.domain.dto.UserDTO;
import com.kevin.code.better.samples.moudles.user.service.UserService;

/**
 * 用户服务实现类
 *
 * @author wangyong
 */
public class UserServiceImpl implements UserService {


  @Override
  public UserDTO queryOneUser(UserBO userBO) {
    //UserBO->UserPO



    //UserPO->UserDTO
    UserDTO userDTO = new UserDTO();

    return userDTO;
  }
}
