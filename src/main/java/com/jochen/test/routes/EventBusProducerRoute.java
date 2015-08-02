package com.jochen.test.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by jochen on 01Aug15.
 */
@Component
public class EventBusProducerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/jochen/IdeaProjects/camel-guava/eventin")
                .to("log:com.jochen.test.routes.EventBusProducerRoute?level=INFO&showHeaders=true&multiline=true")
                .bean(EventBean.class, "processFileEvent")
                .to("guava-eventbus:camelEventBus")
        ;
    }
}
