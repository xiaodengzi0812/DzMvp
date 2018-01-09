package com.dengzi.dzmvp.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dengzi.dzmvp.mvp.proxy.FragmentProxyPresenter;
import com.dengzi.dzmvp.mvp.proxy.IProxyPresenter;

/**
 * @author Djk
 * @Title: mvp基类(LoginFragment)
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public abstract class BaseMvpFragment extends BaseFragment implements BaseView {
    // 代理Presenter
    private IProxyPresenter mProxyPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建一个代理Presenter对象
        mProxyPresenter = new FragmentProxyPresenter<>(this);
        // 绑定当前Presenter
        mProxyPresenter.bindAndCreatePresenter();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // 解绑当前的Presenter
        mProxyPresenter.unBindPresenter();
    }
}
