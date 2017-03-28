package by.beregeiko.remoting.http_invoker;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by Think on 15.02.2017.
 */
public class HttpInvokerClientSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/remoting/http_invoker/http-invoker-app-context.xml");
        context.refresh();
        ContactService contactService = context.getBean("remoteContactService", ContactService.class);
        System.out.println("Finding all contacts");
        List<Contact> contacts = contactService.findAll();
        listContacts(contacts);
        System.out.println ("Finding contact with first name equals Chris");
        contacts = contactService.findByFirstName("Chris");
        listContacts(contacts);
    }

    private static void listContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("");
        }
    }
}
