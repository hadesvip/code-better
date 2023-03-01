package com.kevin.bean.validator.moulder.user.spring.validator.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 用户登陆对象
 *
 * @author kevin
 */
@Data
@Builder
public class UserLoginDto {


    private String userName;


    private String password;


    @Override
    public String toString() {
        return "{" +
                "\"userName\":\"" +
                userName + '\"' +
                ",\"password\":\"" +
                password + '\"' +
                "}";
    }
}
