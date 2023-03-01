package com.kevin.bean.validator.moulder.user.spring.validator;

import com.kevin.bean.validator.moulder.user.spring.validator.dto.UserLoginDto;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public class UserLoginValidatorTest {


    @Test
    public void userLoginValidatorTest() {
        UserLoginDto userLoginDto = UserLoginDto.builder().userName("zhangsan").password("123456").build();
        UserLoginValidator userLoginValidator = new UserLoginValidator();

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");

        BindException errors = new BindException(userLoginDto, "userLoginDto");
        ValidationUtils.invokeValidator(userLoginValidator, userLoginDto, errors);
        if (errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
            for (ObjectError allError : allErrors) {
                String message = messageSource.getMessage(Objects.requireNonNull(allError.getCode()),
                        allError.getArguments(), Locale.CHINA);
                String defaultMessage = allError.getDefaultMessage();

                Logger.getGlobal().info("message:" + message);
                Logger.getGlobal().info("defaultMessage:" + defaultMessage);
            }
        }
    }


}
