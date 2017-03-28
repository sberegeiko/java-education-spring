package by.beregeiko.dependency_injection;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Think on 30.01.2017.
 */
public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/dependency_injection/app-context-annotation.xml");
        context.refresh();
        MessageProvider messageProvider = context.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());

        MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
