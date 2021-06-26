package com.kevin.dev.web.dev.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyong
 */
public class BaseController {

    @Resource
    protected HttpServletRequest request;

    /**
     *
      * @param headerName
     * @return
     */
    protected String getHeader(String headerName){
       return request.getHeader(headerName);
    }




}
