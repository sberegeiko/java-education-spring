package by.beregeiko.dependency_injection.xml;

import by.beregeiko.dependency_injection.MessageProvider;

/**
 * Created by Think on 30.01.2017.
 */
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
