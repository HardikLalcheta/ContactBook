package com.example.demo.service;

import com.example.demo.model.Contact;
import com.example.demo.model.Login;
import java.util.List;

/**
 *
 * @author hardik
 */
public interface ContactService {

    public Contact save(Contact contact);

    public List<Contact> findAll();

    public void delete(Long id);

    public List<Contact> findByUserid(Login l);

    public void put(Long id, Contact c);

    public Contact findById(Long id);
}
