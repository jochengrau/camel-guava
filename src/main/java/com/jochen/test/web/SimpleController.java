package com.jochen.test.web;

import com.google.common.eventbus.EventBus;
import com.jochen.test.events.TextEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jochen on 01Aug15.
 */
@RestController
public class SimpleController {

    private final EventBus eventBus;

    @Autowired
    public SimpleController(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingForm(@RequestBody String input) {
        eventBus.post(new TextEvent(input));
        return "Your post was: " + input;
    }
}
