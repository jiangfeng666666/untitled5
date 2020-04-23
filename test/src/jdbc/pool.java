package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

public class pool {
    @Test
    public void method() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        cpds.setUser("root");
        cpds.setPassword("root");
        cpds.setInitialPoolSize(10);
        Connection connection = cpds.getConnection();
        System.out.println("connection = " + connection);
    }
    @Test
    public void method1() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("h");
        Connection connection = cpds.getConnection();
        System.out.println("connection = " + connection);
    }
}
