package com.kevin.dev.web.user.entity.dto;

import lombok.Data;

/**
 *
 *
 * @author wb_wangyong02
 */
@Data
public class UserRegisterDto {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String rePassword;

    /**
     * 验证码
     */
    private String captcha;

    @Override
    public String toString() {
        return "{" +
                "\"userName\":\"" +
                userName + '\"' +
                ",\"password\":\"" +
                password + '\"' +
                ",\"rePassword\":\"" +
                rePassword + '\"' +
                ",\"captcha\":\"" +
                captcha + '\"' +
                "}";
    }
}
