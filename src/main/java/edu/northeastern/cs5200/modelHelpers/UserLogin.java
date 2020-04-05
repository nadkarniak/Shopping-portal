package edu.northeastern.cs5200.modelHelpers;

import javax.validation.constraints.NotEmpty;

public class UserLogin {

  @NotEmpty
  private String userName;

  @NotEmpty
  private String password;

  @NotEmpty
  private String userType;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }
}
