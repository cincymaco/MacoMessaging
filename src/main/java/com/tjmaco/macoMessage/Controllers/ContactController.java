package com.tjmaco.macoMessage.Controllers;

/**
 * Created by thomasmaco on 11/26/15.
 */

import java.util.List;

import com.tjmaco.macoMessage.Domains.Contact;
import com.tjmaco.macoMessage.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository repo;

    @RequestMapping(value = "/contacts/find/{firstName}/{lastName}", method=RequestMethod.GET)
    public List<Contact> getContactByName(@PathVariable String firstName, @PathVariable String lastName) {
        return repo.findAll();
    }

    @RequestMapping(value = "/contacts/find/{id}", method=RequestMethod.GET)
    public Contact getContactById(@PathVariable String id) {
        return repo.findOne(id);
    }

    @RequestMapping(value = "/contacts/create", method=RequestMethod.POST)
    public Contact create(@RequestBody Contact contact) {
        return repo.save(contact);
    }


    @RequestMapping(value = "/contacts/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }

    @RequestMapping(value = "/contacts/update/{id}", method=RequestMethod.PUT)
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        Contact update = repo.findOne(id);
        update.setEmail(contact.getEmail());
        update.setFacebookProfile(contact.getFacebookProfile());
        update.setFirstName(contact.getFirstName());
        update.setLastName(contact.getLastName());
        update.setPhoneNumber(contact.getPhoneNumber());
        return repo.save(update);
    }


}
