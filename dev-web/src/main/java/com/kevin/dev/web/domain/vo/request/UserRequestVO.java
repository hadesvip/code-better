package com.kevin.dev.web.domain.vo.request;

/**
 * @author wangyong
 */
public class UserRequestVO {

    private String userNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Override
    public String toString() {
        return "UserRequestVO{" +
                "userNo='" + userNo + '\'' +
                '}';
    }
}
