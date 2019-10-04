package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.serviceimpl.LoginDetailsServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/login")
public class LoginDetailsController {

    @Autowired
    private LoginDetailsServiceImpl loginDetailsService;

    @RequestMapping(value = "/logindetails", method = RequestMethod.POST)
    public Long Login(@RequestBody Map<String, Object> data) {
     
        List<Login> db = new ArrayList<>();
        db = loginDetailsService.findByEmail(data.get("email").toString());
        String pwd = data.get("password").toString();
        if (db.toArray().length > 0) {
            if (pwd.equals(db.get(0).getPassword())) {
                return db.get(0).getId();
            }
        }
        return -1L;
    }

    @RequestMapping(value = "/signupdetails", method = RequestMethod.POST)
    public boolean addUser(@RequestBody Map<String, Object> data) {
        Login login = new Login(data.get("email").toString(), data.get("password").toString());
        return loginDetailsService.addUser(login);
    }

}
