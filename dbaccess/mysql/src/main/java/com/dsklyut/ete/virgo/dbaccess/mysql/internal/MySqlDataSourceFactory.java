package com.dsklyut.ete.virgo.dbaccess.mysql.internal;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
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
 * Date: 4/7/11
 * Time: 10:20 AM
 */
final class MySqlDataSourceFactory implements DataSourceFactory {

    Hashtable<String, String> getServiceProperties() throws Exception {
        Driver driver = createDriver(null);
        Hashtable<String, String> result = new Hashtable<String, String>();
        result.put(DataSourceFactory.OSGI_JDBC_DRIVER_CLASS, com.mysql.jdbc.Driver.class.getCanonicalName());
        result.put(DataSourceFactory.OSGI_JDBC_DRIVER_NAME, "mysql");
        result.put(DataSourceFactory.OSGI_JDBC_DRIVER_VERSION, driver.getMajorVersion() + "." + driver.getMinorVersion());
        return result;
    }

    @Override
    public DataSource createDataSource(Properties props) throws SQLException {
        // TODO: populate properties
        return new MysqlDataSource();
    }

    @Override
    public ConnectionPoolDataSource createConnectionPoolDataSource(Properties props) throws SQLException {
        // todo: populate properties
        return new MysqlConnectionPoolDataSource();
    }

    @Override
    public XADataSource createXADataSource(Properties props) throws SQLException {
        // todo: populate properties
        return new MysqlXADataSource();
    }

    @Override
    public Driver createDriver(Properties props) throws SQLException {
        return new com.mysql.jdbc.Driver();
    }
}
