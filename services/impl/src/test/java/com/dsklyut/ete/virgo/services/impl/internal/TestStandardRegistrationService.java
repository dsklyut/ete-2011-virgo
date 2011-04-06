package com.dsklyut.ete.virgo.services.impl.internal;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertNotNull;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 4:34 PM
 */
@ContextConfiguration(locations = {"classpath:META-INF/spring/service.impl-module-context.xml", "classpath:test-emf-context.xml"})
public class TestStandardRegistrationService extends AbstractJUnit4SpringContextTests {

    @Test
    public void testContextSetup() {
        assertNotNull(this.applicationContext);
    }

}
