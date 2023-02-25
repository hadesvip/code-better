package com.kevin.dev.web.user.controller;

import com.kevin.code.better.common.exception.BizException;
import com.kevin.dev.web.user.entity.dto.UserRegisterDto;
import com.kevin.dev.web.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author wangyong
 */

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> register(@RequestBody UserRegisterDto userRegisterDto) {
        //请求参数校验
        if (userRegisterDto == null) {
            throw new BizException("非法请求");
        }
        if (StringUtils.isBlank(userRegisterDto.getCaptcha())) {
            throw new BizException("验证码不能为空");
        }
        if (StringUtils.isBlank(userRegisterDto.getUserName())) {
            throw new BizException("用户名不能为空");
        }
        if (StringUtils.isBlank(userRegisterDto.getPassword())) {
            throw new BizException("密码不能为空");
        }
        if (StringUtils.equals(userRegisterDto.getPassword(), userRegisterDto.getRePassword())) {
            throw new BizException("两次输入的密码不一致");
        }
        //......

        boolean registerRt = userService.register(userRegisterDto);
        if (!registerRt) {
            //监听注册失败逻辑，省略
            throw new BizException("注册失败，请联系客服人员。");
        }
        return ResponseEntity.ok(null);
    }


}
