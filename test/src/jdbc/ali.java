package jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class ali {

    static DataSource source = null;
    static {
        try {
            Properties properties = new Properties();
            FileInputStream inputStream  = new FileInputStream(new File("src//d.properties"));
            properties.load(inputStream);
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    public void method1() throws Exception {
        Connection connection = source.getConnection();
        System.out.println("connection = " + connection);
    }
}
