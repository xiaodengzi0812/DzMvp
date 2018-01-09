package com.dengzi.dzmvp.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Djk
 * @Title: Activity基类
 * @Time: 2018/1/3.
 * @Version:1.0.0
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        initView();
        initListener();
        initData();
    }

    /**
     * 设置布局
     */
    public abstract void setContentView();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化监听事件
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
