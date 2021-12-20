package com.qiuguan.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author created by qiuguan on 2021/12/9 10:36
 */
public class MyMethodInterceptor2 implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("目标方法开始增强222222。。。。。。");

        Object object = proxy.invokeSuper(obj, args);

        return object;
    }
}
