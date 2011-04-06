package com.dsklyut.ete.virgo.services.impl.internal;

import com.dsklyut.ete.virgo.jpa.model.Person;
import com.dsklyut.ete.virgo.jpa.model.Presentation;
import com.dsklyut.ete.virgo.jpa.model.Speaker;
import com.dsklyut.ete.virgo.services.api.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashSet;
import java.util.Set;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 4:18 PM
 */
@Service
@Transactional
final class StandardSchedulingService implements SchedulingService {

    private final JpaTemplate jpaTemplate;

    @Autowired
    StandardSchedulingService(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }

    @Override
    public Set<Presentation> listPresentations() {
        return jpaTemplate.execute(new JpaCallback<Set<Presentation>>() {
            @Override
            public Set<Presentation> doInJpa(EntityManager em) throws PersistenceException {
                CriteriaQuery<Presentation> query = em.getCriteriaBuilder().createQuery(Presentation.class);
                return new HashSet<Presentation>(em.createQuery(query).getResultList());
            }
        });
    }

    @Override
    public Set<Speaker> listSpeakers() {
        return jpaTemplate.execute(new JpaCallback<Set<Speaker>>() {
            @Override
            public Set<Speaker> doInJpa(EntityManager em) throws PersistenceException {
                CriteriaQuery<Speaker> query = em.getCriteriaBuilder().createQuery(Speaker.class);
                return new HashSet<Speaker>(em.createQuery(query).getResultList());
            }
        });
    }

    @Override
    public Presentation registerPresentation(String title, String description, SpeakerInfo... speakers) {
        Presentation presentation = new Presentation(title, description);
        for (SpeakerInfo speakerInfo : speakers) {
            Speaker speaker = new Speaker(new Person(speakerInfo.getFirstName(),
                                                     speakerInfo.getLastName(),
                                                     null,
                                                     speakerInfo.getEmail()));
            speaker.addPresentation(presentation);
            jpaTemplate.persist(speaker);
        }
        return presentation;
    }
}
