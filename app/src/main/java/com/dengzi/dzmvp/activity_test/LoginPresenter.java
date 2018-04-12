package com.dengzi.dzmvp.activity_test;

import com.dengzi.dzmvp.mvp.base.BasePresenter;
import com.dengzi.dzmvp.mvp.base.MvpCallback;

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
        getModel().doLogin(new MvpCallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean data) {
                LoginBean loginBean = data;
                getView().onSuccess(loginBean);
            }

            @Override
            public void onError(int code, String msg) {
                getView().onError(code, msg);
            }
        });
    }
}
