package com.dsklyut.ete.virgo.jpa.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 10:39 AM
 */
@Entity
public class Attendee extends AbstractEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @Basic
    private boolean paidInFull;

    public Attendee() {
    }

    public Attendee(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isPaidInFull() {
        return paidInFull;
    }

    public void setPaidInFull(boolean paidInFull) {
        this.paidInFull = paidInFull;
    }
}
