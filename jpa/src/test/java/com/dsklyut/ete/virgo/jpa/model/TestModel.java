package com.dsklyut.ete.virgo.jpa.model;

import com.dsklyut.ete.virgo.jpa.security.SecurityHolder;
import com.dsklyut.ete.virgo.jpa.security.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.fail;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 11:25 AM
 */
public class TestModel {

    @BeforeClass
    public static void setupJul() {
        // set-up juli to slf4j bridge
        SLF4JBridgeHandler.install();

        // setup security
        SecurityHolder.set(new User("testUser", "Test User"));
    }

    @Test
    public void testLoadingPunit() {
        EntityManagerFactory emf = factory();
        assertNotNull(emf);
        EntityManager em = emf.createEntityManager();
        assertNotNull(em);


    }

    @Test
    public void testPerson() {
        EntityManager em = manager();
        EntityTransaction trn = em.getTransaction();
        // persist
        Person p = new Person();

        try {
            trn.begin();

            p.setEmail("test@test.com");
            p.setFirstName("Dmitry");
            p.setLastName("Sklyut");
            p.setPhone("1234212121");
            em.persist(p);
            em.flush();

            trn.commit();
            em.close();

        } catch (Exception ex) {
            fail(ex.getMessage());
        }


        assertNotNull(p.getId());

        // update
        em = manager();
        trn = em.getTransaction();
        try {
            trn.begin();

            p = em.find(Person.class, p.getId());
            assertNotNull(p);
            p.setEmail("test@newDomain.com");
            em.persist(p);
            em.flush();

            trn.commit();
            em.close();

        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertThat(p.getCreateDate(), not(equalTo(p.getLastUpdateDate())));

        // delete
        em = manager();
        trn = em.getTransaction();
        try {
            trn.begin();
            p = em.merge(p);
            em.remove(p);

            em.flush();
            trn.commit();
            em.close();
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

        em = manager();
        p = em.find(Person.class, p.getId());
        assertNull(p);
    }

    @Test
    public void testFullDomainModelTest() {
        EntityManager em = manager();
        EntityTransaction trn = em.getTransaction();

        Speaker speaker = createSpeaker(createPerson("Speaker", "One"), createPresentation("Something about nothing"));

        Attendee attendee = createAttendee(createPerson("Joe", "Shmoe"));

        try {
            trn.begin();

            em.persist(speaker);
            em.persist(attendee);
            em.flush();
            trn.commit();
        } catch (Exception _) {
            fail(_.getMessage());
        }

    }

    private Speaker createSpeaker(Person person, Presentation presentation) {
        Speaker s = new Speaker(person);
        s.addPresentation(presentation);
        return s;
    }

    private Attendee createAttendee(Person person) {
        return new Attendee(person);
    }

    private Presentation createPresentation(String name) {
        return new Presentation(name, name);
    }

    private static Person createPerson(String first, String last) {
        return new Person(first, last, first + "@" + last + ".com");

    }

    private EntityManager manager() {
        return factory().createEntityManager();
    }

    private EntityManagerFactory factory() {
        return Persistence.createEntityManagerFactory("ete");
    }
}
