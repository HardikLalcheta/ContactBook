package com.example.demo.serviceimpl;

import com.example.demo.service.*;
import com.example.demo.ContactDao.LoginDetailsDao;
import com.example.demo.model.Contact;
import com.example.demo.model.Login;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author hardik
 */
@Service(value="loginDetailsService")
public class LoginDetailsServiceImpl implements LoginDetailsService {

    @Autowired
    private LoginDetailsDao loginDetailsDao;

    @Override
    public Login findById(Long id) {
        return loginDetailsDao.findById(id).get();
    }

    
    
    @Override
    public List<Login> findByEmail(String email) {
        return loginDetailsDao.findByEmail(email);
    }

    @Override
    public boolean addUser(Login l) {
        loginDetailsDao.save(l);
        return true;
    }
}
