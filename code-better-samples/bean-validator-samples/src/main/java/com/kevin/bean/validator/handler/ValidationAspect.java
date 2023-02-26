package com.kevin.bean.validator.handler;

import com.kevin.bean.validator.utils.ValidatorUtils;
import com.kevin.code.better.common.entity.ValidationRt;
import com.kevin.code.better.common.entity.dto.HttpRt;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 验证切面
 *
 * @author kevin
 */
@Aspect
@Component
@Slf4j
public class ValidationAspect {


  @Around("execution(* com.kevin.bean.validator.moulder.user.service.*.*(..))")
  public Object around(ProceedingJoinPoint point) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) point.getSignature();
    Method method = methodSignature.getMethod();
    Object[] args = point.getArgs();
    Parameter[] parameters = method.getParameters();
    for (int i = 0; i < parameters.length; i++) {
      if (parameters[i].isAnnotationPresent(Valid.class)) {
        Object val = args[i];
        ValidationRt validationResult = ValidatorUtils.validateEntity(val);
        if (validationResult.isHasErrors()) {
          return HttpRt.fail(500, validationResult.getErrorMessageOneway());
        }
      }
    }
    return point.proceed();
  }

}
