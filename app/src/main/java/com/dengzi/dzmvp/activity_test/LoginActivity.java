package com.dengzi.dzmvp.activity_test;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dengzi.dzmvp.R;
import com.dengzi.dzmvp.mvp.base.BaseMvpActivity;
import com.dengzi.dzmvp.mvp.inject.InjectPresenter;

public class LoginActivity extends BaseMvpActivity implements LoginContract.ILoginView {
    @InjectPresenter
    private LoginPresenter mPresenter;
    private Button mLoginBtn;
    private TextView mResultTv;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        setTitle("Activity Test");
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mResultTv = (TextView) findViewById(R.id.result_tv);
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
