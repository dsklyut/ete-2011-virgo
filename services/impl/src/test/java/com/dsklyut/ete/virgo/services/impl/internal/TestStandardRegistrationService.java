package com.dsklyut.ete.virgo.services.impl.internal;

import com.dsklyut.ete.virgo.jpa.model.Attendee;
import com.dsklyut.ete.virgo.jpa.security.SecurityHolder;
import com.dsklyut.ete.virgo.jpa.security.User;
import com.dsklyut.ete.virgo.services.api.RegistrationService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 4:34 PM
 */
@ContextConfiguration(locations = {"classpath:META-INF/spring/service.impl-module-context.xml", "classpath:test-emf-context.xml"})
public class TestStandardRegistrationService extends AbstractJUnit4SpringContextTests {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private RegistrationService registrationService;

    private TransactionTemplate template;

    @BeforeClass
    public static void beforeClass() {
        // set-up juli to slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @AfterClass
    public static void cleanupAfterClass() {
        // set-up juli to slf4j bridge
        SLF4JBridgeHandler.uninstall();
    }

    @Before
    public void beforeEach() {
        template = new TransactionTemplate(transactionManager);
        template.afterPropertiesSet();


        SecurityHolder.set(new User("test", "Test User"));
    }

    @After
    public void cleanUp() {
        SecurityHolder.clear();
    }

    @Test
    public void testRegister() {

        Attendee attendee = template.execute(new TransactionCallback<Attendee>() {
            @Override
            public Attendee doInTransaction(TransactionStatus status) {
                return registrationService.register("first", "last", "first@last.com");
            }
        });

        assertNotNull(attendee);
        assertNotNull(attendee.getId());
        assertNotNull(attendee.getPerson());
        assertEquals("first", attendee.getPerson().getFirstName());
        assertEquals("last", attendee.getPerson().getLastName());
        assertEquals("first@last.com", attendee.getPerson().getEmail());

    }


}
