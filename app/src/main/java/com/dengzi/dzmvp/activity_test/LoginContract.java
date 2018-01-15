package com.dengzi.dzmvp.activity_test;


import com.dengzi.dzmvp.mvp.base.BaseModel;
import com.dengzi.dzmvp.mvp.base.BaseView;

/**
 * @author Djk
 * @Title:
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public class LoginContract {

    public interface ILoginModel extends BaseModel {
        LoginBean doLogin();
    }

    public interface ILoginView extends BaseView {
        void onLoading();

        void onError(int code, String msg);

        void onSuccess(LoginBean result);
    }

    public interface ILoginPresenter {
        void doLogin();
    }
}
