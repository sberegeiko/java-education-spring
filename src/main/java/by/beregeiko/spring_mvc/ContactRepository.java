package by.beregeiko.spring_mvc;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Think on 15.02.2017.
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
}
