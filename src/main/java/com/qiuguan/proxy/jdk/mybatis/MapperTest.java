package com.qiuguan.proxy.jdk.mybatis;

import com.qiuguan.proxy.bean.OrderMapper;

/**
 * @author created by qiuguan on 2021/12/10 17:35
 */
public class MapperTest {

    public static void main(String[] args) {

        MapperProxyFactory<OrderMapper> proxyFactory = new MapperProxyFactory<>(OrderMapper.class);

        OrderMapper instance = proxyFactory.createInstance(new MapperProxy());

        instance.saveOrder();
    }
}
