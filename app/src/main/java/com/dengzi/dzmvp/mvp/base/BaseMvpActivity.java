package com.dengzi.dzmvp.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dengzi.dzmvp.mvp.proxy.ActivityProxyPresenter;
import com.dengzi.dzmvp.mvp.proxy.IProxyPresenter;

/**
 * @author Djk
 * @Title: mvp基类(Activity)
 * @Time: 2018/1/2.
 * @Version:1.0.0
 */
public abstract class BaseMvpActivity extends BaseActivity implements BaseView {
    // 代理Presenter
    private IProxyPresenter mProxyPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        createPresenter();
        super.onCreate(savedInstanceState);
    }

    /**
     * 创建Presenter
     */
    protected void createPresenter() {
        // 创建一个代理Presenter对象
        mProxyPresenter = new ActivityProxyPresenter(this);
        // 绑定当前Presenter
        mProxyPresenter.bindAndCreatePresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解绑当前的Presenter
        mProxyPresenter.unBindPresenter();
    }
}
