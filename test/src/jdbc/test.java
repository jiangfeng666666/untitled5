package jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class test {
    @Test
    public void method1() {
        Connection connection = null;
        try {
            QueryRunner runner= new QueryRunner();
            connection = jdbcutile.getconnection();
            String sql = "insert into student(id,name,age)values(?,?,?)";
            int erer = runner.update(connection, sql, 2, "erer", 2);
            System.out.println("erer = " + erer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }
    @Test
    public void method2() throws Exception {
        Connection getconnection = jdbcutile.getconnection();
        QueryRunner runner = new QueryRunner();
        String sql = "select id,name,age from student where id = ?";
        BeanHandler<user> handler = new BeanHandler<>(user.class);
        user query = runner.query(getconnection, sql, handler, 2);
        System.out.println(query);



        String sql2 = "select id,name,age from student where id > ?";
        BeanListHandler<user> beanListHandler = new BeanListHandler<>(user.class);
        List<user> query1 = runner.query(getconnection, sql2, beanListHandler, 1);
        query1.forEach(System.out::println);

        ScalarHandler handler1 = new ScalarHandler();
        String sql3 = "select count(*) from student ";
        Object query2 = runner.query(getconnection, sql3, handler1);
        System.out.println("query2 = " + query2);

    }
}
