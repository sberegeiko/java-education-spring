package by.beregeiko.jpa;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Think on 08.02.2017.
 */
public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/jpa/app-context-annotation.xml");
        context.refresh();

        ContactService contactService = context.getBean("jpaContactService", ContactService.class);

        listContacts(contactService.findAll());
        System.out.println("---------------------------------");

        listContactsWithDetail(contactService.findAllWithDetail());
        System.out.println("---------------------------------");

        Contact contact = contactService.findById(1l);
        System.out.println();
        System.out.println("Contact with id 1:" + contact);
        System.out.println();
        System.out.println("---------------------------------");

        ContactSummaryUntypeImpl contactSummaryUntype = context.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
        contactSummaryUntype.displayAllContactSummary();

        Contact contactForSave = new Contact () ;
        contactForSave.setFirstName("Michael");
        contactForSave.setLastName("Jackson");
        contactForSave.setBirthDate(new Date());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contactForSave.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
        contactForSave.addContactTelDetail(contactTelDetail);
        contactService.save(contactForSave);
        listContactsWithDetail(contactService.findAllWithDetail());
        System.out.println("---------------------------------");

        Contact contactForUpdate = contactService.findById(1l);
        contactForUpdate.setFirstName("Kim Fung");
        Set<ContactTelDetail> contactTels = contactForUpdate.getContactTelDetails();
        ContactTelDetail toDeleteContactTel = null;
        for (ContactTelDetail contactTel: contactTels) {
            if (contactTel.getTelType().equals("Home")) {
                toDeleteContactTel = contactTel;
            }
        }

        contactTels.remove(toDeleteContactTel);
        contactService.save(contactForUpdate);
        listContactsWithDetail(contactService.findAllWithDetail());
        System.out.println("---------------------------------");

        Contact contactForDelete = contactService.findById(1l);
        contactService.delete(contactForDelete);
        listContactsWithDetail(contactService.findAllWithDetail());
        System.out.println("---------------------------------");
    }

    private static void listContactsWithDetail(List<Contact> contacts){
        System.out.println();
        System.out.println("Listing contacts with details:");
        for(Contact contact : contacts){
            System.out.println(contact);
            if(contact.getContactTelDetails() != null){
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if(contact.getHobbies() != null){
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }

    private static void listContacts(List<Contact> contacts){
        System.out.println();
        System.out.println("Listing contacts without details:");
        for(Contact contact : contacts){
            System.out.println(contact);
            System.out.println();
        }
    }
}
