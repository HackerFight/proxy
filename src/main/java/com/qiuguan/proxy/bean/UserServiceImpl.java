package com.qiuguan.proxy.bean;

/**
 * @author created by qiuguan on 2021/12/10 17:02
 */
public class UserServiceImpl implements UserService {


    @Override
    public void buy(String name) {
        System.out.println(name + " 买了车");
    }
}
