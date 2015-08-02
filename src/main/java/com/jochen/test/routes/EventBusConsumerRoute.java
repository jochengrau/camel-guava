package com.jochen.test.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by jochen on 01Aug15.
 */
@Component
public class EventBusConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("guava-eventbus:camelEventBus?listenerInterface=com.jochen.test.routes.GuavaListener")
                .bean(EventBean.class, "processTextEvent")
                .convertBodyTo(String.class)
                .to("log:com.jochen.test.routes.EventBusConsumerRoute?level=INFO&showHeaders=true&multiline=true")
                .to("file:/Users/jochen/IdeaProjects/camel-guava/eventout");
    }
}
