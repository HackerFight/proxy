package com.qiuguan.proxy.cglib;

import com.qiuguan.proxy.bean.Car;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * @author created by qiuguan on 2021/12/9 10:27
 */
public class CglibTest {

    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\temp");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);

        /**
         * 如果只有一个回调，则直接这样指定即可
         */
        enhancer.setCallback(new MyMethodInterceptor());


        /**
         * 如果有多个回调可选，则需要配合 CallbackFilter 一起工作
         * 创建代理对象时，将会调用 CallbackFilter 的 accept 方法，返回的是 callbacks 集合中的索引
         * 从而确定具体用哪个回调
         */
        Callback[] callbacks = new Callback[]{ new MyMethodInterceptor(), new MyMethodInterceptor2() };

        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                /**
                 * 返回0，使用 MyMethodInterceptor
                 * 返回1，使用 MyMethodInterceptor2
                 */
                return 0;
            }
        });

        enhancer.setCallbacks(callbacks);

        Car car = (Car)enhancer.create();
        car.run("宝马");

    }
}
