package com.dengzi.dzmvp.mvp.proxy;

/**
 * @author Djk
 * @Title: 静态代理生成Presenter，解决Activity，LoginFragment，ViewGroup使用Mpv时copy多份代码的问题
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public interface IProxyPresenter {

    /**
     * 创建和绑定Presenter
     */
    void bindAndCreatePresenter();

    /**
     * 销毁时解绑Presenter
     */
    void unBindPresenter();
}
