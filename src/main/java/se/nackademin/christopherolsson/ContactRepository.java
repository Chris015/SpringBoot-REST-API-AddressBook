package se.nackademin.christopherolsson;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.nackademin.christopherolsson.entity.Contact;

import java.util.List;

/**
 * @author Christopher Olsson on 2017-05-22.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c WHERE c.firstName LIKE %?1% OR c.lastName LIKE %?1%")
    List<Contact> findByFirstNameOrLastNameContaining(String searchString);
}