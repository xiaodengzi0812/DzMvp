package com.dengzi.dzmvp.fragment_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dengzi.dzmvp.R;
import com.dengzi.dzmvp.activity_test.LoginBean;
import com.dengzi.dzmvp.activity_test.LoginContract;
import com.dengzi.dzmvp.activity_test.LoginPresenter;
import com.dengzi.dzmvp.mvp.base.BaseMvpFragment;
import com.dengzi.dzmvp.mvp.inject.InjectPresenter;

/**
 * @author Djk
 * @Title:
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */

public class LoginFragment extends BaseMvpFragment implements LoginContract.ILoginView {
    @InjectPresenter
    private LoginPresenter mPresenter;
    private Button mLoginBtn;
    private TextView mResultTv;

    @Override
    protected void initView() {
        mLoginBtn = (Button) mContentView.findViewById(R.id.login_btn);
        mResultTv = (TextView) mContentView.findViewById(R.id.result_tv);
    }

    @Override
    protected void initListener() {
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.doLogin();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login, container, false);
    }

    @Override
    public void onLoading() {
        mResultTv.setText("加载中...");
    }

    @Override
    public void onError(int code, String msg) {
        mResultTv.setText("加载失败");
    }

    @Override
    public void onSuccess(LoginBean result) {
        mResultTv.setText(result.toString());
    }
}
