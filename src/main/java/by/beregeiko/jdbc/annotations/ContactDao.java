package by.beregeiko.jdbc.annotations;

import java.util.List;

/**
 * Created by Think on 06.02.2017.
 */
public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    String findFirstNameById(Long id);
    List<Contact> findAllWithDetail();
    void insert(Contact contact);
    void insertWithDetail(Contact contact);
    void update(Contact contact);
}
