package com.example.demo.service;

import com.example.demo.model.Login;
import java.util.List;

/**
 *
 * @author hardik
 */
public interface LoginDetailsService {

    public Login findById(Long id);

    public List<Login> findByEmail(String email);

    public boolean addUser(Login l);
}
