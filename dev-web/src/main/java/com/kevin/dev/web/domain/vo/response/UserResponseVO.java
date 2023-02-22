package com.kevin.dev.web.domain.vo.response;

/**
 * 用户响应
 * @author wangyong
 */
public class UserResponseVO {

    private String userNo;

    private String nickName;

    private String userName;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userNo='" + userNo + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
