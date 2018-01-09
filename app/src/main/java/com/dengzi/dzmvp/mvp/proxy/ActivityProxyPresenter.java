package com.dengzi.dzmvp.mvp.proxy;

import com.dengzi.dzmvp.mvp.base.BaseView;

/**
 * @author Djk
 * @Title: Activity对应的Presenter实现
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public class ActivityProxyPresenter<V extends BaseView> extends BaseProxyPresenter<V> {

    public ActivityProxyPresenter(V view) {
        super(view);
    }

    // 这里还可以添加Activity对应的特殊方法
}
