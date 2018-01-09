package com.dengzi.dzmvp.mvp.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;

/**
 * @author Djk
 * @Title: Presenter基类
 * @Time: 2018/1/2.
 * @Version:1.0.0
 */
public class BasePresenter<M extends BaseModle, V extends BaseView> {
    // 绑定的View层
    private V mView;
    // 代理View层，用来解决每次去判断View层是否存在的问题
    private V mProxyView;
    // 绑定的Model层
    private M mModel;

    /**
     * 将View层attach到Presenter层中，说白了就是P层与V层建立关连
     *
     * @param view View层
     */
    public void attachView(final V view) {
        // 创建Model
        createModle();
        this.mView = view;
        // 创建动态代理,用来解决每次去判断View层是否存在的问题
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(),
                view.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 如果View为null，则返回null
                        if (mView == null) {
                            return mView;
                        }
                        // 如果View不为null，则执行相应的方法
                        return method.invoke(mView, args);
                    }
                }
        );
    }

    /**
     * 创建Module
     */
    private void createModle() {
        try {
            // 获取泛型中的class
            Class<M> mClazz = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            // 反射生成
            mModel = mClazz.newInstance();
        } catch (Exception e) {
        }
    }


    /**
     * 在销毁时解绑View和Presenter层
     */
    public void detachView() {
        this.mView = null;
        this.mProxyView = null;
    }

    /**
     * 获取绑定的View层实例
     *
     * @return View层实例
     */
    public V getView() {
        return mProxyView;
    }

    /**
     * 获取绑定的Model层实例
     *
     * @return Model层实例
     */
    public M getModle() {
        return mModel;
    }
}
