package jdbcDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class baseDAO {
    /**
     * 增删改操作
     * @param connection
     * @param sql
     * @param objects
     * @throws Exception
     */
    public void update(Connection connection,String sql,Object...objects)  {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0 ; i<objects.length;i++){
                statement.setObject(i+1,objects[i]);
            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 查询操作，返回一个对象
     * @param connection
     * @param clazz
     * @param sql
     * @param objects
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T select(Connection connection , Class<T> clazz,String sql , Object...objects) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i+1, objects[i]);
            }
            resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            T t;
            if (resultSet.next()){

               t = clazz.newInstance();
                for (int i = 0 ; i<columnCount ;i++) {
                    String label = metaData.getColumnLabel(i+1);
                    Field field = clazz.getDeclaredField(label);
                    field.setAccessible(true);
                    Object object = resultSet.getObject(i+1);
                    field.set(t,object);
                }
                return t;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }
    public  <E> ArrayList<E> SumSlect(Connection connection,Class<E> clazz ,String sql , Object...objects){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<E> arrayList = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i+1,objects[i]);
            }
            resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            arrayList = new ArrayList<>();
            while (resultSet.next()){
                E e = clazz.newInstance();
                int count = metaData.getColumnCount();
                for (int i = 0; i < count; i++) {
                    String label = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(label);
                    field.setAccessible(true);
                    Object object = resultSet.getObject(i + 1);
                    field.set(e, object);
                }
                arrayList.add(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
       return arrayList;
    }
    public  <T> T getvalue(Connection connection, String sql ,Object...objects ){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i+1, objects[i]);
            }
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                return (T) resultSet.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
        return null;
    }
    public Connection getConnection() {
        FileInputStream inputStream = null;
        Connection connection = null;
        try {
            inputStream = new FileInputStream("information");
            Properties properties = new Properties();
            properties.load(inputStream);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return connection;
    }
}
