package by.beregeiko.spring_mvc;

import java.util.List;

/**
 * Created by Think on 21.02.2017.
 */
public class ContactGrid {
    private int totalPages;
    private int currentPage;
    private long totalRecords;
    private List<Contact> contactData;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Contact> getContactData() {
        return contactData;
    }

    public void setContactData(List<Contact> contactData) {
        this.contactData = contactData;
    }

    @Override
    public String toString() {
        return "ContactGrid{" +
                "totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                ", totalRecords=" + totalRecords +
                ", contactData=" + contactData +
                '}';
    }
}
