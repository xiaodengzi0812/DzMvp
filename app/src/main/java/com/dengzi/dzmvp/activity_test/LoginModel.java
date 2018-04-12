package com.dengzi.dzmvp.activity_test;

import com.dengzi.dzmvp.mvp.base.MvpCallback;

/**
 * @author Djk
 * @Title:
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public class LoginModel implements LoginContract.ILoginModel {

    @Override
    public void doLogin(MvpCallback<LoginBean> callback) {
        LoginBean loginBean = new LoginBean();
        loginBean.setUserName("dengzi");
        loginBean.setUserPwd("fuck");
        callback.onSuccess(loginBean);
    }
}
