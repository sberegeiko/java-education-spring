package by.beregeiko.remoting.http_invoker;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Think on 15.02.2017.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);
}
