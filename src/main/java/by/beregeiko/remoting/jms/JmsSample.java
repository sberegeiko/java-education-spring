package by.beregeiko.remoting.jms;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Think on 15.02.2017.
 */
public class JmsSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/remoting/jms/jms-sender-app-context.xml",
                "classpath:META-INF/spring/remoting/jms/jms-listener-app-context.xml");
        context.refresh();
        MessageSender messageSender = context.getBean("messageSender", MessageSender.class);
        for (int i = 0; i < 10; i++) {
            messageSender.sendMessage("Test message: " + i);
        }
    }
}
