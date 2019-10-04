package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author raj
 */
@Entity
@Table(name = "contact",uniqueConstraints={@UniqueConstraint(columnNames={"userid","number"})})
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "number")
    private String number;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userid")
    private Login user;
    
    public Contact() {
    }

    public Contact(String firstName, String number, String email, String city) {
        this.firstName = firstName;
        this.number = number;
        this.email = email;
        this.city = city;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Login getUser() {
        return user;
    }

    public void setUser(Login user) {
        this.user = user;
    }

    
    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", firstName=" + firstName + ", number=" + number + ", email=" + email + ", city=" + city + '}';
    }

   
    

}
