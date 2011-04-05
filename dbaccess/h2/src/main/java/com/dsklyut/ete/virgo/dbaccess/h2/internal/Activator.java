package com.dsklyut.ete.virgo.dbaccess.h2.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.jdbc.DataSourceFactory;

import java.util.Hashtable;

/**
 * User: dsklyut
 * Date: 4/5/11
 * Time: 3:21 PM
 */
public class Activator implements BundleActivator {

    private ServiceRegistration<DataSourceFactory> factoryServiceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        H2DataSourceFactory factory = new H2DataSourceFactory();
        Hashtable<String, String> serviceProps = factory.getServiceProperties();

        factoryServiceRegistration = context.registerService(DataSourceFactory.class, factory, serviceProps);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (factoryServiceRegistration != null) {
            factoryServiceRegistration.unregister();
            factoryServiceRegistration = null;
        }
    }
}
