package com.yan.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author: yanshuai
 * @date： 2017/10/17
 */
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "helloworld.q")
    public void receive(String message) {
        LOGGER.info("received message='{}'", message);
        System.out.println("Consumer收到的报文为:"+message);
        latch.countDown();
    }

}
