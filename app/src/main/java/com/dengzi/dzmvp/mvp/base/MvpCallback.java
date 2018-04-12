package com.dengzi.dzmvp.mvp.base;

/**
 * @author Djk
 * @Title: mvp 数据回调
 * @Time: 2018/1/3.
 * @Version:1.0.0
 */
public interface MvpCallback<D> {
    /**
     * 数据请求成功
     *
     * @param data 请求到的数据
     */
    void onSuccess(D data);

    /**
     * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网、
     * 缺少权限，内存泄露等原因导致无法连接到请求数据源。
     */
    void onError(int code, String msg);
}
