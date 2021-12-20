package com.qiuguan.proxy.jdk;

import com.qiuguan.proxy.bean.UserService;
import com.qiuguan.proxy.bean.UserServiceImpl;

/**
 * @author created by qiuguan on 2021/12/10 17:08
 */
public class JDKTest {

    public static void main(String[] args) {

        MyJdkProxyFactory proxyFactory = new MyJdkProxyFactory(new UserServiceImpl());

        UserService proxy = (UserService)proxyFactory.createProxy();

        proxy.buy("wq");
    }
}
