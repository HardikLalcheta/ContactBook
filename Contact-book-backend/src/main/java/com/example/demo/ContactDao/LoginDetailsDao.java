package com.example.demo.ContactDao;


import com.example.demo.model.Login;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hardik
 */
@Repository
public interface LoginDetailsDao extends JpaRepository<Login,Long>  {


    public List<Login> findByEmail(String email);
    
}
