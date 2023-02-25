package com.kevin.code.better.samples.moudles.user.domain.po;

/**
 * 用户信息
 *
 * @author wangyong
 */
public class UserPO {

  private String userName;

  private String userEmail;


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  @Override
  public String toString() {
    return "{"
        + "\"userName\":\""
        + userName + '\"'
        + ",\"userEmail\":\""
        + userEmail + '\"'
        + '}';
  }
}
