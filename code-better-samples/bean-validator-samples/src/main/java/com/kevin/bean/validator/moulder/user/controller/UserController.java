package com.kevin.bean.validator.moulder.user.controller;

import com.kevin.bean.validator.moulder.user.entity.dto.request.UserRegisterV1ReqDto;
import com.kevin.bean.validator.moulder.user.entity.dto.response.UserRegisterV1ResDto;
import com.kevin.bean.validator.moulder.user.service.UserService;
import com.kevin.code.better.common.exception.BizException;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 *
 * @author kevin
 */
@RestController
@RequestMapping("/api/user")
public class UserController {


  @Resource
  private UserService userService;


  /**
   * @param reqDto
   * @return
   */
  @PostMapping("/v1/register")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> registerV1(@RequestBody UserRegisterV1ReqDto reqDto) {
    UserRegisterV1ResDto resDto = userService.register(reqDto);
    if (!resDto.isSuccess()) {
      //监听注册失败逻辑，省略....
      throw new BizException("注册失败，请联系客服人员。");
    }
    return ResponseEntity.ok(resDto);
  }

  @PostMapping("/v2/register")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> registerV2(@RequestBody UserRegisterV1ReqDto reqDto) {
    UserRegisterV1ResDto resDto = userService.register(reqDto);
    if (!resDto.isSuccess()) {
      //监听注册失败逻辑，省略....
      throw new BizException("注册失败，请联系客服人员。");
    }
    return ResponseEntity.ok(resDto);
  }








}
