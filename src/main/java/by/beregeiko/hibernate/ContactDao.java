package by.beregeiko.hibernate;

import java.util.List;

/**
 * Created by Think on 06.02.2017.
 */
public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
