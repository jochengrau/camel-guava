package com.jochen.test.events;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by jochen on 01Aug15.
 */
@Service
public class FileEventListener {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Subscribe
    public void handleEvent(FileEvent message){
        log.info("Message: " + message);
    }

}
