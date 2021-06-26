package com.kevin.dev.web.dev.web.builder;

import com.kevin.dev.web.dev.web.domain.vo.response.UserResponseVO;

/**
 * @author wangyong
 */
public final class UserResponseVOBuilder {

    private final UserResponseVO userResponseVO;

    private UserResponseVOBuilder() {
        userResponseVO = new UserResponseVO();
    }

    public static UserResponseVOBuilder newBuilder() {
        return new UserResponseVOBuilder();
    }

    public UserResponseVOBuilder setUserNo(String userNo) {
        userResponseVO.setUserNo(userNo);
        return this;
    }

    public UserResponseVOBuilder setNickName(String nickName) {
        userResponseVO.setNickName(nickName);
        return this;
    }

    public UserResponseVOBuilder setUserName(String userName) {
        userResponseVO.setUserName(userName);
        return this;
    }

    public UserResponseVO build() {
        return userResponseVO;
    }
}
