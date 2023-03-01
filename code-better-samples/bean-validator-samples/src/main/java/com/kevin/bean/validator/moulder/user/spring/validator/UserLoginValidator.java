package com.kevin.bean.validator.moulder.user.spring.validator;

import com.kevin.bean.validator.moulder.user.spring.validator.dto.UserLoginDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public class UserLoginValidator implements Validator {


    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    /**
     * 限制xxxValidator的职责,不可能将所有的校验都交给一个validator来做。
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     *              being asked if it can {@link #validate(Object, Errors) validate}
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return UserLoginDto.class.isAssignableFrom(clazz);
    }

    /**
     * 将target校验的错误信息放入到errors中
     *
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.field.required");
        UserLoginDto login = (UserLoginDto) target;
        if (login.getPassword() != null
                && login.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
            errors.rejectValue("password", "password.field.min.length",
                    new Object[]{MINIMUM_PASSWORD_LENGTH},
                    "密码至少必须满足[" + MINIMUM_PASSWORD_LENGTH + "] 字符");
        }


    }
}
