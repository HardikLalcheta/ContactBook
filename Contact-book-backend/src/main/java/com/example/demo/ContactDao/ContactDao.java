package com.example.demo.ContactDao;

import com.example.demo.model.Contact;
import com.example.demo.model.Login;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hardik
 */
@Repository
public interface ContactDao extends JpaRepository<Contact,Long> {

    public List<Contact> findByUser(Login l);
    
}
