package by.beregeiko.jdbc.annotations;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Think on 07.02.2017.
 */
public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/jdbc/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        List<Contact> contacts = contactDao.findAll();
        List<Contact> contactsByFirstName = contactDao.findByFirstName("Chris");

        listContacts(contacts);
        System.out.println("-------------------------------------------------");
        listContacts(contactsByFirstName);
        System.out.println("-------------------------------------------------");

        Contact contactUpdate = new Contact();
        contactUpdate.setId(1l);
        contactUpdate.setFirstName("Chris");
        contactUpdate.setLastName("John");
        contactUpdate.setBirthDate(new Date(
                (new GregorianCalendar(1977, 11, 1)).getTime().getTime()));

        contactDao.update(contactUpdate);

        listContacts(contactDao.findAll());

        System.out.println("-------------------------------------------------");

        Contact contactInsert = new Contact();
        contactInsert.setFirstName("Rod");
        contactInsert.setLastName("Johnson");
        contactInsert.setBirthDate(new Date(
                (new GregorianCalendar(2011, 10, 1)).getTime().getTime()));

        contactDao.insert(contactInsert);

        listContacts(contactDao.findAllWithDetail());

        Contact contactInsertWithDetail = new Contact();
        contactInsertWithDetail.setFirstName("Michael");
        contactInsertWithDetail.setLastName("Jackson");
        contactInsertWithDetail.setBirthDate(new Date(
                (new GregorianCalendar(1964, 10, 1)).getTime().getTime()));

        List<ContactTelDetail> contactTelDetails = new ArrayList<ContactTelDetail>();
        ContactTelDetail contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Home");
        contactTelDetail.setTelNumber("11111111");
        contactTelDetails.add(contactTelDetail);
        contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Mobile");
        contactTelDetail.setTelNumber("22222222");
        contactTelDetails.add(contactTelDetail);
        contactInsertWithDetail.setContactTelDetails(contactTelDetails);
        contactDao.insertWithDetail(contactInsertWithDetail);

        listContacts(contactDao.findAllWithDetail());


    }

    private static void listContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null)
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            System.out.println();
        }
    }
}
