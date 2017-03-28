package by.beregeiko.hibernate;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Think on 08.02.2017.
 */
public class SpringHibernateSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/hibernate/app-context-annotation.xml");
        context.refresh();

        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);

        listContacts(contactDao.findAll());
        System.out.println("---------------------------------");

        listContactsWithDetail(contactDao.findAllWithDetail());
        System.out.println("---------------------------------");

        Contact contact = contactDao.findById(1l);
        System.out.println();
        System.out.println("Contact with id 1:" + contact);
        System.out.println();
        System.out.println("---------------------------------");

        Contact contactForSave = new Contact () ;
        contactForSave.setFirstName("Michael");
        contactForSave.setLastName("Jackson");
        contactForSave.setBirthDate(new Date());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contactForSave.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
        contactForSave.addContactTelDetail(contactTelDetail);
        contactDao.save(contactForSave);
        listContactsWithDetail(contactDao.findAllWithDetail());
        System.out.println("---------------------------------");

        Contact contactForUpdate = contactDao.findById(1l);
        contactForUpdate.setFirstName("Kim Fung");
        Set<ContactTelDetail> contactTels = contactForUpdate.getContactTelDetails();
        ContactTelDetail toDeleteContactTel = null;
        for (ContactTelDetail contactTel: contactTels) {
            if (contactTel.getTelType().equals("Home")) {
                toDeleteContactTel = contactTel;
            }
        }

        contactForUpdate.removeContactTelDetail(toDeleteContactTel);
        contactDao.save(contactForUpdate);
        listContactsWithDetail(contactDao.findAllWithDetail());
        System.out.println("---------------------------------");

        Contact contactForDelete = contactDao.findById(1l);
        contactDao.delete(contactForDelete);
        listContactsWithDetail(contactDao.findAllWithDetail());
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
