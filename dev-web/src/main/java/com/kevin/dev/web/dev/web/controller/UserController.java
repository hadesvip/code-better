package com.kevin.dev.web.dev.web.controller;

import com.kevin.dev.web.dev.web.builder.UserResponseVOBuilder;
import com.kevin.dev.web.dev.web.domain.vo.request.UserRequestVO;
import com.kevin.dev.web.dev.web.domain.vo.response.UserResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author wangyong
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/queryUser/{userNo}")
    public ResponseEntity<UserResponseVO> queryUser(@PathVariable("userNo") String userNo){
        logger.info("获取用户信息,请求参数:{}", userNo);
        String contentType = this.getHeader("Content-Type");
        String token = this.getHeader("token");
        logger.info("content-type:{},token:{}",contentType,token);
        UserResponseVO userResponseVO = UserResponseVOBuilder.newBuilder()
                .setUserNo(UUID.randomUUID().toString().replaceAll("-", ""))
                .setUserName("admin")
                .setNickName("管理员")
                .build();
        logger.info("获取用户信息,响应参数:{}",userResponseVO);
        return ResponseEntity.ok(userResponseVO);
    }


    @GetMapping("/saveUser")
    public ResponseEntity<Object> saveUser(@RequestBody UserRequestVO userRequestVO){
        logger.info("获取用户信息,请求参数:{}", userRequestVO);
        return ResponseEntity.ok(new Object());
    }







}
