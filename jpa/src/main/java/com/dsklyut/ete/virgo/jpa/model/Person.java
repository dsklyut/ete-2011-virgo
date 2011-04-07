package com.dsklyut.ete.virgo.jpa.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 10:46 AM
 */
@Entity
public class Person extends AbstractEntity {

    @Basic
    private String firstName;
    @Basic
    private String lastName;

    @Column(unique = true)
    private String email;

    @Basic
    private String phone;

    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        this(firstName, lastName, email, null);
    }

    public Person(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
