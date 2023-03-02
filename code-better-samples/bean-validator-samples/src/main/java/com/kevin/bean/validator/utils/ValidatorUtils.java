package com.kevin.bean.validator.utils;

import com.kevin.code.better.common.entity.ValidationRt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

/**
 * 验证工具，提供了Spring中自动BindingResult验证的封装以及手动验证实体的功能
 *
 * @author kevin
 */
public class ValidatorUtils {


  private static final Validator validator = Validation.buildDefaultValidatorFactory()
      .getValidator();

  private BindingResult bindingResult;
  private boolean existLengthError = true;
  private String resultErrorInfo;

  public static ValidatorUtils create() {
    ValidatorUtils validatorUtils = new ValidatorUtils();
    return validatorUtils;
  }

  public ValidatorUtils setBindingResult(BindingResult bindingResult) {
    this.bindingResult = bindingResult;
    return this;
  }

  public ValidatorUtils generate() {
    StringBuffer buffer = new StringBuffer();
    List<FieldError> fieldErrors = this.bindingResult.getFieldErrors();
    for (FieldError error : fieldErrors) {
      buffer.append("字段：").append(error.getField()).append("，错误原因：")
          .append(error.getDefaultMessage()).append(";");
      if (StringUtils.equals(error.getCode(), "Length")) {
        this.existLengthError = false;
      }
    }
    this.resultErrorInfo = buffer.toString();
    return this;
  }

  public boolean isNotExistLengthError() {
    return existLengthError;
  }

  public String getResultErrorInfo() {
    return resultErrorInfo;
  }

  public String getRandomFieldError() {
    return this.bindingResult.getFieldError().getField() + this.bindingResult.getFieldError()
        .getDefaultMessage();
  }

  /**
   * 校验某个实体类，只校验默认分组，其它分组不会校验
   */
  public static <T> ValidationRt validateEntity(T obj) {
    ValidationRt result = new ValidationRt();
    Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
    if (!CollectionUtils.isEmpty(set)) {
      result.setHasErrors(true);
      Map<String, String> errorMsg = new HashMap<String, String>();
      for (ConstraintViolation<T> cv : set) {
        errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
      }
      result.setErrorMsg(errorMsg);
    }
    return result;
  }

  /**
   * 按指定的分组校验某个实体
   */
  public static <T> ValidationRt validateEntity(T obj, Class<?>... groups) {
    ValidationRt result = new ValidationRt();
    Set<ConstraintViolation<T>> set = validator.validate(obj, groups);
    if (!CollectionUtils.isEmpty(set)) {
      result.setHasErrors(true);
      Map<String, String> errorMsg = new HashMap<String, String>();
      for (ConstraintViolation<T> cv : set) {
        errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
      }
      result.setErrorMsg(errorMsg);
    }
    return result;
  }

  /**
   * 校验某个实体类中的某个字段
   */
  public static <T> ValidationRt validateProperty(T obj, String propertyName) {
    ValidationRt result = new ValidationRt();
    Set<ConstraintViolation<T>> set = validator.validateProperty(obj, propertyName, Default.class);
    if (!CollectionUtils.isEmpty(set)) {
      result.setHasErrors(true);
      Map<String, String> errorMsg = new HashMap<String, String>();
      for (ConstraintViolation<T> cv : set) {
        errorMsg.put(propertyName, cv.getMessage());
      }
      result.setErrorMsg(errorMsg);
    }
    return result;
  }

  /**
   * 按指定的分组校验某个实体类中的某个字段
   */
  public static <T> ValidationRt validateProperty(T obj, String propertyName,
      Class<?>... groups) {
    ValidationRt result = new ValidationRt();
    Set<ConstraintViolation<T>> set = validator.validateProperty(obj, propertyName, groups);
    if (!CollectionUtils.isEmpty(set)) {
      result.setHasErrors(true);
      Map<String, String> errorMsg = new HashMap<String, String>();
      for (ConstraintViolation<T> cv : set) {
        errorMsg.put(propertyName, cv.getMessage());
      }
      result.setErrorMsg(errorMsg);
    }
    return result;
  }
}
