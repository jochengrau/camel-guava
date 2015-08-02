package com.jochen.test.config;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by jochen on 01Aug15.
 */
@Configuration
public class EventBusConfig {

    @Bean(name = {"eventBus", "camelEventBus"})
    public EventBus eventBus() {
        EventBus eventBus = new EventBus();
        return eventBus;
    }


}
