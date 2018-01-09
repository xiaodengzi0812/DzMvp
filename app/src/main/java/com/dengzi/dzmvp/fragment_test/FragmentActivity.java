package com.dengzi.dzmvp.fragment_test;

import android.support.v4.app.FragmentManager;

import com.dengzi.dzmvp.R;
import com.dengzi.dzmvp.mvp.base.BaseMvpActivity;

/**
 * @author Djk
 * @Title:
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
public class FragmentActivity extends BaseMvpActivity {
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_fragment);
    }

    @Override
    protected void initView() {
        setTitle("Fragment Test");
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frame_layout, new LoginFragment()).commit();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
