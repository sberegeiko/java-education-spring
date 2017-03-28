package by.beregeiko.jdbc;

import java.util.List;

/**
 * Created by Think on 06.02.2017.
 */
public interface ContactDao {
//    String findFirstNameById(Long id);
    String findLastNameById(Long id);
//    List<Contact> findAll();
    List<Contact> findAllWithDetail();
}
