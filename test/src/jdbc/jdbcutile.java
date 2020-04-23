package jdbc;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

public class jdbcutile {
    public static Connection getconnection() throws Exception {
        FileInputStream inputStream = new FileInputStream("information");
        Properties properties = new Properties();
        properties.load(inputStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        inputStream.close();
        return connection;
    }
    public static void closeconnection(Connection connection) throws Exception {
        connection.close();
        System.out.println("已关闭");
    }
    public static void update(Connection getconnection, String sql ,Object...objects) throws Exception {
        PreparedStatement statement = getconnection.prepareStatement(sql);
        for (int i = 0 ; i< objects.length ; i++){
            statement.setObject(i+1,objects[i]);
        }
        statement.execute();
        statement.close();
    }
    public static user select(String sql,Object...objects) throws Exception {
        Connection getconnection = getconnection();
        PreparedStatement preparedStatement = getconnection.prepareStatement(sql);
        for (int i = 0 ; i<objects.length ; i++){
            preparedStatement.setObject(i+1, objects[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        if (resultSet.next()){
            user user = new user();
            Class clazz = jdbc.user.class;
            for (int i = 0 ; i<columnCount; i++){
                Object object = resultSet.getObject(i+1);
                String columnName = metaData.getColumnName(i+1);
                Field declaredField = clazz.getDeclaredField(columnName);
                declaredField.set(user,object);
            }
            resultSet.close();
            preparedStatement.close();
            jdbcutile.closeconnection(getconnection);
            return user;
        }
        return null;
    }
    public static <T> T Sumselect(Class<T> clazz,String sql , Object...objects) throws Exception {
        Connection getconnection = getconnection();
        PreparedStatement preparedStatement = getconnection.prepareStatement(sql);
        for (int i = 0 ; i<objects.length;i++){
            preparedStatement.setObject(i+1, objects[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        T t;
        if (resultSet.next()) {
            t = clazz.newInstance();
            for (int i = 0 ; i<columnCount; i++){
                String label = metaData.getColumnLabel(i + 1);
                Object object = resultSet.getObject(i + 1);
                Field field = null;
                field.setAccessible(true);
                field = clazz.getDeclaredField(label);
                field.set(t,object);
            }
            return t;
        }
       return null;
    }
}
