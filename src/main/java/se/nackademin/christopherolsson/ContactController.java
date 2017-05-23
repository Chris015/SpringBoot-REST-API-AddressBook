package se.nackademin.christopherolsson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.nackademin.christopherolsson.entity.Contact;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Christopher Olsson on 2017-05-22.
 */
@RestController
public class ContactController {


    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/contacts", method = POST)
    public void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }

    @RequestMapping(value = "/contacts/delete/{contactId}", method = POST)
    public void deleteContact(@PathVariable long contactId) {
        contactService.deleteContact(contactId);
    }


    @RequestMapping(value = "/contacts/search", method = GET)
    public List<Contact> searchContacts(@RequestParam(value="searchString") String searchString){
        return contactService.searchContacts(searchString);
    }

    @RequestMapping(value = "/contacts", method = GET)
    public List<Contact> retrieveAllContacts() {
        Iterable<Contact> contacts = contactService.retrieveAllContacts();
        return (contacts != null) ? (List<Contact>) contacts : new ArrayList<>();
    }
}
