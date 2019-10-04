package com.example.demo.serviceimpl;

import com.example.demo.service.*;
import com.example.demo.ContactDao.ContactDao;
import com.example.demo.model.Contact;
import com.example.demo.model.Login;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hardik
 */
@Service
public class ContactServiceImpl implements ContactService {

    private ContactDao contactDao;

    @Autowired
    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> list = new ArrayList<>();
        contactDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(Long id) {
        contactDao.deleteById(id);
    }

    @Override
    public List<Contact> findByUserid(Login l) {
        return contactDao.findByUser(l);
    }

    @Override
    public void put(Long id, Contact c) {
        contactDao.save(c);
    }

    @Override
    public Contact findById(Long id) {
        return contactDao.findById(id).get();
    }

}
