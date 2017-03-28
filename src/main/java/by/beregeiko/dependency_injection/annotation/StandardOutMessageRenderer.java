package by.beregeiko.dependency_injection.annotation;

import by.beregeiko.dependency_injection.MessageProvider;
import by.beregeiko.dependency_injection.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Think on 17.01.2017.
 */
@Service("messageRenderer")
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

    @Autowired
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
