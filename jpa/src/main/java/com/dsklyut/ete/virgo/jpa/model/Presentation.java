package com.dsklyut.ete.virgo.jpa.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 10:39 AM
 */
@Entity
public class Presentation extends AbstractEntity {

    @Basic
    private String title;

    @Column(length = 2000)
    private String description;

    @ManyToMany(mappedBy = "presentations")
    private Set<Speaker> speakers = new HashSet<Speaker>();


    public Presentation() {
    }

    public Presentation(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }
}
