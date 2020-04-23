package jdbcDAO;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentDaoimplTest {
    studentDaoimpl test = new studentDaoimpl();
    baseDAO baseDAO = new baseDAO();
    @Test
    public void insert() throws SQLException {
        Connection connection = test.getConnection();
        student stu = new student(7, "七七", 7);
        test.insert(connection, stu);
        connection.close();
    }

    @Test
    public void delete() throws SQLException {
        Connection connection = test.getConnection();
        test.delete(connection, 5);
        connection.close();
    }

    @Test
    public void updata() throws SQLException {
        Connection connection = test.getConnection();
        student stu = new student(6, "liuliu", 6);
        test.updata(connection, stu,5);
        connection.close();
    }

    @Test
    public void select() throws SQLException {
        Connection connection = test.getConnection();
        student select = test.select(connection, 6);
        System.out.println("select = " + select);
        connection.close();
    }

    @Test
    public void sumSelect() throws SQLException {
        Connection connection = test.getConnection();
        ArrayList<student> students = test.SumSelect(connection);
        for (int i = 0; i < students.size(); i++) {
            System.out.println("students.get(i) = " + students.get(i));
        }
        connection.close();
    }

    @Test
    public void count() throws SQLException {
        Connection connection = test.getConnection();
        long count = test.count(connection);
        System.out.println("count = " + count);
        connection.close();
    }
}