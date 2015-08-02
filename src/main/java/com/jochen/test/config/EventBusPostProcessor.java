package com.jochen.test.config;

/**
 * Created by jochen on 01Aug15.
 */

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;


public class EventBusPostProcessor implements BeanPostProcessor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EventBus eventBus;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        Method[] methods = bean.getClass().getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Subscribe.class) != null) {
                eventBus.register(bean);
                log.info("Bean {} containing method {} was subscribed to {}",
                        new Object[]{
                                beanName, method.getName(),
                                EventBus.class.getCanonicalName()
                        });
                break;
            }
        }
        return bean;
    }

}

