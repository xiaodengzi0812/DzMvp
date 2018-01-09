package com.dengzi.dzmvp.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Djk
 * @Title:
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public abstract class BaseFragment extends Fragment {
    protected View mContentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = createView(inflater, container, savedInstanceState);
        initView();
        initListener();
        initData();
        return mContentView;
    }

    /**
     * 初始化监听事件
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 创建View
     */
    protected abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
