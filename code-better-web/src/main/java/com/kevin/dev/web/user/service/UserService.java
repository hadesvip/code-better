package com.kevin.dev.web.user.service;

import com.kevin.dev.web.user.entity.dto.UserRegisterDto;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author wangyong02
 */
public interface UserService {

    boolean register(UserRegisterDto userRegisterDto);
}
