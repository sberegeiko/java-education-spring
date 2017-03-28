package by.beregeiko.remoting.http_invoker;

import java.util.List;

/**
 * Created by Think on 06.02.2017.
 */
public interface ContactService {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
