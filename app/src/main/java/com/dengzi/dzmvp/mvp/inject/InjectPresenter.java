package com.dengzi.dzmvp.mvp.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Djk
 * @Title: 注入注解
 * @Time: 2018/1/8.
 * @Version:1.0.0
 */
@Target(ElementType.FIELD)// 属性
@Retention(RetentionPolicy.RUNTIME)// 运行时
public @interface InjectPresenter {
}
