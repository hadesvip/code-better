package com.kevin.dev.web.builder;

import com.kevin.dev.web.domain.vo.request.UserRequestVO;

/**
 * @author wangyong
 */
public final class UserRequestVOBuilder {

    private final UserRequestVO userRequestVO;

    private UserRequestVOBuilder() {
        userRequestVO = new UserRequestVO();
    }

    public static UserRequestVOBuilder newBuilder() {
        return new UserRequestVOBuilder();
    }

    public UserRequestVOBuilder setUserNo(String userNo) {
        userRequestVO.setUserNo(userNo);
        return this;
    }

    public UserRequestVO build() {
        return userRequestVO;
    }
}
