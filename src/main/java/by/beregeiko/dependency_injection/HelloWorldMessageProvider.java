package by.beregeiko.dependency_injection;

import org.springframework.stereotype.Service;

/**
 * Created by Think on 17.01.2017.
 */
@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello Vlad and Sergey!!!";
    }
}
