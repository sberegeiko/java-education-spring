package by.beregeiko.jdbc.annotations;

/**
 * Created by Think on 07.02.2017.
 */
public class ContactTelDetail {
    private Long id;
    private Long contactId;
    private String telType;
    private String telNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String toString() {
        return "Contact Tel Detail - Id: " + id + ", Contact id: " + contactId
                + ", Type: " + telType + ", Number: " + telNumber;
    }
}
