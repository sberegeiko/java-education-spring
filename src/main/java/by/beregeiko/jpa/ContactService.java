package by.beregeiko.jpa;

import java.util.List;

/**
 * Created by Think on 06.02.2017.
 */
public interface ContactService {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
    List<Contact> findAllByNativeQuery();
}
