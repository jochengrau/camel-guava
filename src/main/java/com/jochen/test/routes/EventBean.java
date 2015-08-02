package com.jochen.test.routes;

import com.jochen.test.events.FileEvent;
import com.jochen.test.events.TextEvent;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by jochen on 01Aug15.
 */
public class EventBean {

    Logger log = LoggerFactory.getLogger(EventBean.class);


    public TextEvent processTextEvent(TextEvent event){
        log.info("EventBean: event = " + event.toString());
        return event;
    }

    public FileEvent processFileEvent(Exchange exchange
            , @Header("CamelFileName") String fileName
            , @Header("CamelFileAbsolutePath") String absolutePath
            , @Header("CamelFileLastModified") long lastModifiedTimestamp
    ){

//        GenericFile genericFile = (GenericFile) exchange.getIn().getBody();
//        File file = (File) genericFile.getFile();
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(absolutePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileEvent fileEvent = new FileEvent(fileName, absolutePath, lastModifiedTimestamp, content);

        return fileEvent;
    }
}
