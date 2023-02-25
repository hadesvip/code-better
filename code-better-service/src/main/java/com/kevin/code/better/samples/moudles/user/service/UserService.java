package com.kevin.code.better.samples.moudles.user.service;

import com.kevin.code.better.samples.moudles.user.domain.bo.UserBO;
import com.kevin.code.better.samples.moudles.user.domain.dto.UserDTO;

/**
 * 用户服务
 *
 * @author wangyong
 */
public interface UserService {


  UserDTO queryOneUser(UserBO userBO);


}
