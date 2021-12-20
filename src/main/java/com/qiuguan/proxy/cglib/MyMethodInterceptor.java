package com.qiuguan.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("目标方法开始增强。。。。。。");

        Object object = proxy.invokeSuper(obj, args);

        return object;
    }  
}