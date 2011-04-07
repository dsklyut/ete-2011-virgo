package com.dsklyut.ete.virgo.dbaccess.mysql.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * User: dsklyut
 * Date: 4/7/11
 * Time: 10:18 AM
 */
public class Activator implements BundleActivator {

    private ServiceRegistration<org.osgi.service.jdbc.DataSourceFactory> serviceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
