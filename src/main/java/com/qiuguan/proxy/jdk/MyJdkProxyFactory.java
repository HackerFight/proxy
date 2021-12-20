package com.qiuguan.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author created by qiuguan on 2021/12/10 16:48
 *
 * 根据目标对象去创建代理对象
 */
public class MyJdkProxyFactory implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private final Object proxyTarget;

    public MyJdkProxyFactory(Object proxyTarget) {
        this.proxyTarget = proxyTarget;
    }

    /**
     * 创建代理对象
     * @return
     */
    public Object createProxy(){
        return Proxy.newProxyInstance(proxyTarget.getClass().getClassLoader(),
                proxyTarget.getClass().getInterfaces(), this);
    }


    /**
     * 调用代理对象的拦截方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("开始代理。。。。。。");

        Object ret = method.invoke(proxyTarget, args);

        System.out.println("代理结束。。。。。。");

        return ret;
    }
}
