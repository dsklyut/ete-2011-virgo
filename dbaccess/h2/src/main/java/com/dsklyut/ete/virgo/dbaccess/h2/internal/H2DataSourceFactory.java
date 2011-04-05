package com.dsklyut.ete.virgo.dbaccess.h2.internal;

import org.h2.jdbcx.JdbcDataSource;
import org.osgi.service.jdbc.DataSourceFactory;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;

/**
 * User: dsklyut
 * Date: 4/5/11
 * Time: 3:23 PM
 */
final class H2DataSourceFactory implements DataSourceFactory {

    Hashtable<String, String> getServiceProperties() {
        Driver driver = org.h2.Driver.load();
        Hashtable<String, String> result = new Hashtable<String, String>();
        result.put(DataSourceFactory.OSGI_JDBC_DRIVER_CLASS, org.h2.Driver.class.getCanonicalName());
        result.put(DataSourceFactory.OSGI_JDBC_DRIVER_NAME, "h2");

        result.put(DataSourceFactory.OSGI_JDBC_DRIVER_VERSION, driver.getMajorVersion() + "." + driver.getMinorVersion());
        return result;
    }

    @Override
    public DataSource createDataSource(Properties props) throws SQLException {
        return createNativeDataSource(props);
    }

    @Override
    public ConnectionPoolDataSource createConnectionPoolDataSource(Properties props) throws SQLException {
        return createNativeDataSource(props);
    }

    @Override
    public XADataSource createXADataSource(Properties props) throws SQLException {
        return createNativeDataSource(props);
    }

    @Override
    public Driver createDriver(Properties props) throws SQLException {
        return org.h2.Driver.load();
    }

    private JdbcDataSource createNativeDataSource(Properties props) throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setPassword(props.getProperty(DataSourceFactory.JDBC_PASSWORD));
        dataSource.setUser(props.getProperty(DataSourceFactory.JDBC_USER));
        dataSource.setURL(props.getProperty(DataSourceFactory.JDBC_URL));
        return dataSource;
    }
}
