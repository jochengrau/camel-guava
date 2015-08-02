package com.jochen.test.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by jochen on 01Aug15.
 */
@Component
public class SimpleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/Users/jochen/IdeaProjects/camel-guava/infile")
                .to("log:com.jochen.test.routes.SimpleRoute?level=INFO&showHeaders=true&multiline=true")
                .to("file:/Users/jochen/IdeaProjects/camel-guava/outfile");
    }

}
