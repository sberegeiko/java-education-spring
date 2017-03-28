package by.beregeiko.jpa;

import java.io.Serializable;

/**
 * Created by Think on 09.02.2017.
 */
public class ContactSummary implements Serializable {
    private String firstName;
    private String lastName;
    private String homeTelNumber;

    public ContactSummary(String firstName, String lastName, String homeTelNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTelNumber = homeTelNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeTelNumber() {
        return homeTelNumber;
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName + ", LastName: " + lastName +
                ", HomeTelNumber: " + homeTelNumber;
    }
}
