package com.dsklyut.ete.virgo.services.impl.internal;

import com.dsklyut.ete.virgo.jpa.model.Attendee;
import com.dsklyut.ete.virgo.jpa.model.Person;
import com.dsklyut.ete.virgo.services.api.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 3:48 PM
 */
@Service
@Transactional
final class StandardRegistrationService implements RegistrationService {

    private final JpaTemplate jpaTemplate;

    @Autowired
    StandardRegistrationService(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }

    @Override
    public Attendee register(String firstName, String lastName, String email) {
        Attendee attendee = new Attendee(new Person(firstName, lastName, email));
        jpaTemplate.persist(attendee);
        return attendee;
    }
}
