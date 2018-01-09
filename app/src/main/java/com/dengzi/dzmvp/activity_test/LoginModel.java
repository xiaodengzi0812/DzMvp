package com.dengzi.dzmvp.activity_test;

/**
 * @author Djk
 * @Title:
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public class LoginModel implements LoginContract.ILoginModel {

    @Override
    public LoginBean doLogin() {
        LoginBean loginBean = new LoginBean();
        loginBean.setUserName("dengzi");
        loginBean.setUserPwd("fuck");
        return loginBean;
    }
}
