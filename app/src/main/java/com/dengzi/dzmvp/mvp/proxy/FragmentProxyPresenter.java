package com.dengzi.dzmvp.mvp.proxy;

import com.dengzi.dzmvp.mvp.base.BaseView;

/**
 * @author Djk
 * @Title: LoginFragment 对应的Presenter实现
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public class FragmentProxyPresenter<V extends BaseView> extends BaseProxyPresenter<V> {

    public FragmentProxyPresenter(V view) {
        super(view);
    }

    // 这里还可以添加Fragment对应的特殊方法
}
