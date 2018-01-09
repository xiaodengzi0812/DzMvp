package com.dengzi.dzmvp.activity_test;

import android.os.SystemClock;

import com.dengzi.dzmvp.mvp.base.BasePresenter;

/**
 * @author Djk
 * @Title:
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.ILoginView> implements LoginContract.ILoginPresenter {

    @Override
    public void doLogin() {
        getView().onLoading();
        LoginBean loginBean = getModle().doLogin();
        getView().onSuccess(loginBean);
    }
}