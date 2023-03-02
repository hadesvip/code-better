package com.kevin.bean.validator.moulder.user.hibernate.validator;

import com.kevin.bean.validator.moulder.user.entity.dto.request.UserRegisterV1ReqDto;
import com.kevin.bean.validator.moulder.user.entity.dto.response.UserRegisterV1ResDto;
import com.kevin.bean.validator.moulder.user.hibernate.validator.dto.UserRegisterDto;
import com.kevin.code.better.common.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
@RequestMapping("/api/user")
@Controller
public class UserController {


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> registerV2(@RequestBody @Validated UserRegisterDto reqDto) {
        //省略业务逻辑
        return ResponseEntity.ok(null);
    }

}
