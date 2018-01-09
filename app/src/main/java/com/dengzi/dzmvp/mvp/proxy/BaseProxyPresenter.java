package com.dengzi.dzmvp.mvp.proxy;

import android.util.Log;

import com.dengzi.dzmvp.mvp.base.BasePresenter;
import com.dengzi.dzmvp.mvp.base.BaseView;
import com.dengzi.dzmvp.mvp.inject.InjectPresenter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Djk
 * @Title: 静态代理生成Presente的基类，基类中实现绑定和解绑，注入创建Presenter
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public class BaseProxyPresenter<V extends BaseView> implements IProxyPresenter {
    // 解决一个View对应多个Presenter的情况
    private List<BasePresenter> mPresenterList = new ArrayList<>();
    // 与P层绑定的View层
    private V mView;

    public BaseProxyPresenter(V view) {
        this.mView = view;
    }

    @Override
    public void bindAndCreatePresenter() {
        // 扫描所有的属性
        Field[] fields = mView.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 拿到我们要注入的注解
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            // 如果注解存在，则说明要注入
            if (injectPresenter != null) {
                // 获取注解的class类type
                Class<?> typeClazz = field.getType();
                try {
                    // 创建一个对应class的Presenter
                    BasePresenter basePresenter = (BasePresenter) typeClazz.newInstance();
                    // 注入
                    field.set(mView, basePresenter);
                    // 关连V和P
                    basePresenter.attachView(mView);
                    // 添加到集合
                    mPresenterList.add(basePresenter);
                } catch (Exception e) {
                    throw new NullPointerException("无法解析的注解类：" + typeClazz.getName());
                }
            }
        }
    }

    @Override
    public void unBindPresenter() {
        for (BasePresenter basePresenter : mPresenterList) {
            if (basePresenter != null) {
                basePresenter.detachView();
            }
        }
    }

}
