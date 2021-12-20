package com.qiuguan.proxy.jdk.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author created by qiuguan on 2021/12/10 17:26
 */
public class MapperProxy implements InvocationHandler {

    /**
     * 将全部业务的CRUD 操作逻辑，封装到 invoke 方法内部
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getDeclaringClass().equals(Object.class)) {
            return method.invoke(this, args);
        }


        //这里是没有代理对象的
        //method.invoke()

        //因为我不需要这个对象就可以完成CRUD的

        System.out.println("代理执行操作。。。。。。");
        return null;
    }
}
