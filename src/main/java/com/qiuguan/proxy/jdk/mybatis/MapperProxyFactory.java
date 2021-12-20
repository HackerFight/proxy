package com.qiuguan.proxy.jdk.mybatis;

import java.lang.reflect.Proxy;

/**
 * @author created by qiuguan on 2021/12/10 17:26
 */
public class MapperProxyFactory<T>{

    private Class<T> mapper;

    public MapperProxyFactory(Class<T> mapper) {
        this.mapper = mapper;
    }

    @SuppressWarnings("all")
    public T createInstance(MapperProxy mapperProxy) {
        return (T)Proxy.newProxyInstance(mapper.getClassLoader(), new Class[]{mapper}, mapperProxy);
    }

}
