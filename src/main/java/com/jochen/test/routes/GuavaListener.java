package com.jochen.test.routes;

import com.google.common.eventbus.Subscribe;
import com.jochen.test.events.TextEvent;

/**
 * Created by jochen on 01Aug15.
 */
public interface GuavaListener {

    @Subscribe
    void eventReceived(TextEvent event);
}
