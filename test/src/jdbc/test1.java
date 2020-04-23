package jdbc;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class test1 {
    @Test
    public void method() throws Exception {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("connection = " + connection);
    }
    @Test
    public void method1() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("connection = " + connection);
    }
    @Test
    public void method2() throws Exception {
        FileInputStream inputStream = new FileInputStream("information");
        Properties properties = new Properties();
        properties.load(inputStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url  = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "insert into student(id,name,age) value (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 6);
        preparedStatement.setString(2, "小六");
        preparedStatement.setInt(3, 2);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
    @Test
    public void method3() throws Exception {
        FileInputStream inputStream = new FileInputStream("information");
        Properties properties = new Properties();
        properties.load(inputStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String sql = "insert into student(id,name,age) value (?,?,?)";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "王五");
        preparedStatement.setInt(3, 8);
        preparedStatement.execute();
        String sql2 = "update student set name = ? where id = ? ";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        preparedStatement1.setString(1, "万八");
        preparedStatement1.setInt(2, 2);
        preparedStatement1.execute();
        preparedStatement.close();
        preparedStatement1.close();
        inputStream.close();
        connection.close();



    }
    @Test
    public void method4() throws Exception {
        Connection getconnection = jdbcutile.getconnection();
        System.out.println(getconnection );
        jdbcutile.closeconnection(getconnection );
    }
    @Test
    public void method5() throws Exception {
        Connection getconnection = jdbcutile.getconnection();
        String sql = "delete from student where id = ?";
        jdbcutile.update(getconnection,sql,2);
        String sql2 = "update student set name = ? where id = ?";
        jdbcutile.update(getconnection,sql2, "大一",1);
        getconnection.close();
    }
    @Test
    public void method6() throws Exception {
        Connection getconnection = jdbcutile.getconnection();
        String sql= "select * from student where id = 1";
        PreparedStatement preparedStatement = getconnection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            user u1 = new user(id, name, age);
            System.out.println("u1 = " + u1);
        }
        preparedStatement.close();
        jdbcutile.closeconnection(getconnection);
    }
    @Test
    public void method7() throws Exception {
        String sql = "select * from student ";
        user select = jdbcutile.select(sql);
        System.out.println("select = " + select);

        String sql1 = "select * from student ";
        user select1 = jdbcutile.select(sql1);
        System.out.println("select = " + select1);
    }
    @Test
    public void method8() throws Exception {

        String sql = "select teacher_id id from teacher";
        teacher sumselect = jdbcutile.Sumselect(teacher.class, sql);
        System.out.println("sumselect = " + sumselect);
    }
    @Test
    public void method9() throws Exception {
        Connection connection = jdbcutile.getconnection();
        String sql = "insert into student(id,name,age,image) value (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, 4);
        statement.setObject(2, "中三");
        statement.setObject(3, 4);
        InputStream inputStream = new FileInputStream(new File("1.jpg"));
        statement.setBlob(4, inputStream);
        statement.execute();
        inputStream.close();
        statement.close();
        jdbcutile.closeconnection(connection);
    }
    @Test
    public void method10() throws Exception {
        Connection connection = jdbcutile.getconnection();
        String sql = "select * from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, 3);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            user user = new user(id, name, age);
            System.out.println("user = " + user);
            Blob blob = resultSet.getBlob(4);
            InputStream binaryStream = blob.getBinaryStream();
            FileOutputStream outputStream = new FileOutputStream(new File("123.jpg"));
            byte[] bytes = new byte[1024];
            int length;
            while ((length = binaryStream.read(bytes))!=-1){
                outputStream.write(bytes, 0, length);
            }
            outputStream.close();
            binaryStream.close();
            statement.close();
            jdbcutile.closeconnection(connection);
        }
    }
    @Test
    public void method11() throws Exception {
        Connection connection = jdbcutile.getconnection();
        String string = "insert into t1(id) value (?)";
        PreparedStatement statement = connection.prepareStatement(string);
        connection.setAutoCommit(false);
        long l = System.currentTimeMillis();
        for (int i = 0 ; i<=10000 ; i++){
            statement.setObject(1,i );
            statement.addBatch();
            if (i%200==0){
                statement.executeBatch();
                statement.clearBatch();
            }

        }
        connection.commit();
        statement.close();
        jdbcutile.closeconnection(connection);
        long l1 = System.currentTimeMillis();
        System.out.println("l1 = " + (l1-l));
    }
    @Test
    public void method12() {
        Connection connection = null;
        try {
            connection = jdbcutile.getconnection();
            connection.setAutoCommit(false);
            String sql = "update t2 set money = money - 100 where name = ?";
            jdbcutile.update(connection, sql, "张三");
            String sql1 = "update t2 set money = money + 100 where name = ?";
            jdbcutile.update(connection, sql1, "李四");

            connection.commit();
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


    }
}
