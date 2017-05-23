package se.nackademin.christopherolsson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.nackademin.christopherolsson.entity.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christopher Olsson on 2017-05-23.
 */

@Component
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void addContact(Contact newContact) {
        Contact contact = new Contact(newContact.getFirstName(),
                newContact.getLastName(),
                newContact.getEmailAddress());
        contactRepository.save(contact);
    }

    public void deleteContact(long contactId) {
        contactRepository.delete(contactId);
    }

    public List<Contact> searchContacts(String searchString) {
        return contactRepository.findByFirstNameOrLastNameContaining(searchString);
    }

    public List<Contact> retrieveAllContacts() {
        Iterable<Contact> contacts = contactRepository.findAll();
        return (contacts != null) ? (List<Contact>) contacts : new ArrayList<>();
    }
}
