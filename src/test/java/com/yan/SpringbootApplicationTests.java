package com.yan;

import com.yan.main.Sender;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

//    private static ApplicationContext applicationContext;
//
//    @Autowired
//    void setContext(ApplicationContext applicationContext) {
//        SpringbootApplicationTests.applicationContext = applicationContext;
//    }
//
//    @AfterClass
//    public static void afterClass() {
//        ((ConfigurableApplicationContext) applicationContext).close();
//    }
//
//    @ClassRule
//    public static EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();

    @Autowired
    private Sender sender;


    @Test
    public void testReceive() throws Exception {
        Destination destination = new ActiveMQTopic("helloworld.q");
        sender.send(destination, "Hello Spring JMS ActiveMQ!");
    }
}
