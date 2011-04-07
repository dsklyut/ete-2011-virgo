package com.dsklyut.ete.virgo.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 10:39 AM
 */
@Entity
public class Speaker extends AbstractEntity {

    @OneToOne(cascade = {CascadeType.ALL})
    private Person person;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SPEAKER_PRESENTATIONS")
    private Set<Presentation> presentations = new HashSet<Presentation>();

    @Column(length = 2500, nullable = true)
    private String bio;

    public Speaker() {
    }

    public Speaker(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(Set<Presentation> presentations) {
        this.presentations = presentations;
    }

    public void addPresentation(Presentation preso) {
        this.presentations.add(preso);
        preso.getSpeakers().add(this);
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
