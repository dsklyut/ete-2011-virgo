package com.dsklyut.ete.virgo.jpa.model;

import com.dsklyut.ete.virgo.jpa.security.SecurityHolder;
import com.dsklyut.ete.virgo.jpa.security.User;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 10:47 AM
 */
@MappedSuperclass
class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;

    @Basic
    private String createUser;
    @Basic
    private String lastUpdateUser;

    AbstractEntity() {
    }

    public Long getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @PreUpdate
    void preUpdate() {
        User user = SecurityHolder.currentUser();
        this.lastUpdateUser = user.getUserName();
        this.lastUpdateDate = new Date();
    }

    @PrePersist
    void prePersist() {
        User user = SecurityHolder.currentUser();
        this.createDate = new Date();
        this.createUser = user.getUserName();
        preUpdate();
    }
}
