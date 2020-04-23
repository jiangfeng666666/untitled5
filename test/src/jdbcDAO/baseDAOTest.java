package jdbcDAO;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class baseDAOTest {
    baseDAO baseDAO = new baseDAO();
    @Test
    public void updateTest(){
        Connection connection = baseDAO.getConnection();
        String sql = "insert into student(id,name,age) values (?,?,?)";
        baseDAO.update(connection, sql,5,"五",5 );
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    public void selectTest(){
        Connection connection = baseDAO.getConnection();
        String sql = "select id,name,age from student where id = ?";
        student select = baseDAO.select(connection, student.class, sql, 5);
        System.out.println(select);
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    public void SumSelectTest(){
        Connection connection = baseDAO.getConnection();
        String sql ="select id,name,age from student where id > ?";
        ArrayList<student> students = baseDAO.SumSlect(connection, student.class, sql, 1);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    public void getValueTest(){
        Connection connection = baseDAO.getConnection();
        String sql = "select count(*) FROM student";
        Object student = baseDAO.getvalue(connection, sql);
        System.out.println("student = " + student);
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
