package com.imooc.ad.index;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Qinyi.
 */
@Component
public class DataTable implements ApplicationContextAware, PriorityOrdered {

    private static ApplicationContext applicationContext;

    public static final Map<Class, Object> dataTableMap =
            new ConcurrentHashMap<>();

    /**
     * 初始化
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(
            ApplicationContext applicationContext) throws BeansException {
        DataTable.applicationContext = applicationContext;
    }

    /**
     * 设置排序初始化，数字越小，越先初始化
     * @return
     */
    @Override
    public int getOrder() {
        return PriorityOrdered.HIGHEST_PRECEDENCE;
    }

    /**
     * 给出对应的类型就可以获得索引的服务类
     * @param clazz
     * @param <T>
     * @return
     */
    @SuppressWarnings("all")
    public static <T> T of(Class<T> clazz) {

        T instance = (T) dataTableMap.get(clazz);
        if (null != instance) {
            return instance;
        }

        dataTableMap.put(clazz, bean(clazz));
        return (T) dataTableMap.get(clazz);
    }

    /**
     * 通过上下文，根据名字获取bean
     * @param beanName
     * @param <T>
     * @return
     */
    @SuppressWarnings("all")
    private static <T> T bean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 通过上下文，根据类的形式获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    @SuppressWarnings("all")
    private static <T> T bean(Class clazz) {
        return (T) applicationContext.getBean(clazz);
    }
}
