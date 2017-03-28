package by.beregeiko.dependency_injection.xml;

import by.beregeiko.dependency_injection.MessageProvider;

/**
 * Created by Think on 17.01.2017.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello Vlad and Sergey!!!";
    }
}
