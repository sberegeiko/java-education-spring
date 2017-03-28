package by.beregeiko.dependency_injection;

/**
 * Created by Think on 17.01.2017.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}