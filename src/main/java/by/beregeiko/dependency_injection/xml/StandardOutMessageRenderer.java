package by.beregeiko.dependency_injection.xml;

import by.beregeiko.dependency_injection.MessageProvider;
import by.beregeiko.dependency_injection.MessageRenderer;

/**
 * Created by Think on 17.01.2017.
 */
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRenderer.class.getName());
            // Вы должны установить свойство messageProvider класса
        }
        System.out.println(messageProvider.getMessage());
    }

    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
