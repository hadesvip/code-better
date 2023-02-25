package com.kevin.bean.validator.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevin.code.better.common.entity.dto.HttpRt;
import javax.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 封装统一返回数据
 *
 * @author kevin
 */
@RestControllerAdvice
public class HttpResponseBodyAdvice implements ResponseBodyAdvice<Object> {

  @Resource
  private ObjectMapper objectMapper;

  @Override
  public boolean supports(MethodParameter returnType,
      Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  @SneakyThrows
  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType,
      MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
      ServerHttpRequest request, ServerHttpResponse response) {
    if (body instanceof String) {
      return objectMapper.writeValueAsString(HttpRt.success(body));
    }
    if (body instanceof HttpRt) {
      return body;
    }
    return HttpRt.success(body);
  }
}
