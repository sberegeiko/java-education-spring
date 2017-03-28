package by.beregeiko.jdbc;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by Think on 06.02.2017.
 */
public class JdbcContactDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/jdbc/app-context-xml.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contactsWithDetail = contactDao.findAllWithDetail();

        System.out.println("Last name for contact id 1 is: " +
                contactDao.findLastNameById(1l));
        System.out.println("-------------------------------");

        for (Contact contact : contactsWithDetail) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null)
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            System.out.println();
        }
    }
}
