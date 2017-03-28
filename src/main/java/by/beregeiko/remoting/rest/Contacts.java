package by.beregeiko.remoting.rest;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Think on 16.02.2017.
 */
public class Contacts implements Serializable {
    private List<Contact> contacts;

    public Contacts() {
    }

    public Contacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
