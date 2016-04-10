package com.xsalefter.stackoverflowmvn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnectionTest {

    private static final Logger LOG = LoggerFactory.getLogger(JDBCConnectionTest.class);

    @Test
    public void testLoadDriver() throws ClassNotFoundException, SQLException {
        Class.forName(org.postgresql.Driver.class.getName());
        final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/general_testing", "postgres", "admin");
        final java.sql.PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"UTILISATEUR\"");
        final ResultSet rs = ps.executeQuery();

        if (rs.next()) LOG.info(">>> Connection success!");
        else LOG.error(">>> cannot connect to postgresql database.");

        rs.close();
        ps.close();
        connection.close();
    }
}
