package com.dsklyut.ete.virgo.services.impl.internal.support;

import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

/**
 * User: dsklyut
 * Date: 4/7/11
 * Time: 10:45 AM
 * <p/>
 * Allow for <code>EntityManagerFactory</code> looked up in service registry to participate in Spring managed transaction.
 * Modeled after {@link org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean}
 */
final class SpringEntityManagerFactoryDecorator extends AbstractEntityManagerFactoryBean {

    private final EntityManagerFactory nativeEntityManagerFactory;

    SpringEntityManagerFactoryDecorator(EntityManagerFactory nativeFactory) {
        this.nativeEntityManagerFactory = nativeFactory;
    }

    @Override
    protected EntityManagerFactory createNativeEntityManagerFactory() throws PersistenceException {
        return nativeEntityManagerFactory;
    }
}
