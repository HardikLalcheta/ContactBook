package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.model.Login;
import com.example.demo.serviceimpl.ContactServiceImpl;
import com.example.demo.serviceimpl.LoginDetailsServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hardik
 */
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;
    @Autowired
    private LoginDetailsServiceImpl loginDetailsService;

    @RequestMapping(value = "/contact/{userid}", method = RequestMethod.GET)
    public List<Contact> listUser(@PathVariable(value = "userid") Long userId) {
        Login l = loginDetailsService.findById(userId);
        return contactService.findByUserid(l);
    }

    @RequestMapping(value = "/contact/{userid}", method = RequestMethod.POST)
    public Contact create(@PathVariable(value = "userid") Long userId, @RequestBody Contact contact) {
        contact.setUser(loginDetailsService.findById(userId));
        return contactService.save(contact);
    }

    @RequestMapping(value = "/contact/{userid}/{id}", method = RequestMethod.PUT)
    public boolean put(@PathVariable(value = "userid") Long userId, @PathVariable(value = "id") Long id, @RequestBody Contact c) {
        System.out.println(c);
        c.setUser(loginDetailsService.findById(userId));
        contactService.put(id, c);

        return true;
    }

    @RequestMapping(value = "/contact/{userid}/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable(value = "userid") Long userId, @PathVariable(value = "id") Long id) {
        Contact c = contactService.findById(id);
        if (c.getUser().getId() == userId) {
            contactService.delete(id);
            return true;
        }
        return false;
    }

}
