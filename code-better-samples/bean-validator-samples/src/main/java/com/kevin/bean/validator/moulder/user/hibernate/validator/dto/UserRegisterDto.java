package com.kevin.bean.validator.moulder.user.hibernate.validator.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author wangyong
 */
@Data
public class UserRegisterDto {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Valid
    private List<UserRegisterAddressDto> addressList;

    @Override
    public String toString() {
        return "{" +
                "\"userName\":\"" +
                userName + '\"' +
                ",\"password\":\"" +
                password + '\"' +
                ",\"addressList\":" +
                addressList +
                "}";
    }
}
