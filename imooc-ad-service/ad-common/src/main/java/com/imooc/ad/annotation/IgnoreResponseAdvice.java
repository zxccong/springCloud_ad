package com.imooc.ad.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Qinyi.
 */
//可以表示在类上，可以定义来方法上
@Target({ElementType.TYPE, ElementType.METHOD})
//运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
