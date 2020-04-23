package jdbcDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class studentDaoimpl extends baseDAO implements studentDAO {
    @Override
    public void insert(Connection connection, student stu) {
        String sql = "insert into student(id,name,age) values (?,?,?)";
        update(connection,sql,stu.getId(),stu.getName(),stu.getAge());
    }

    @Override
    public void delete(Connection connection, int id) {
        String sql = "delete from student where id = ?";
        update(connection, sql, id);
    }

    @Override
    public void updata(Connection connection, student stu,int id) {
        String sql = "update student set id = ?,name = ?,age = ? where id = ?";
        update(connection, sql, stu.getId(),stu.getName(),stu.getAge(),id);
    }

    @Override
    public student select(Connection connection,int id) {
        String sql = "select id,name,age from student where id = ?";
        student select = select(connection, student.class, sql, id);
        return select;
    }

    @Override
    public ArrayList<student> SumSelect(Connection connection) {
        String sql = "select id,name,age from student";
        ArrayList<student> students = SumSlect(connection, student.class, sql);
        return students;
    }

    @Override
    public long count(Connection connection) {
        String sql = "select count(*) from student";
        Object getvalue = getvalue(connection, sql);

        return (long) getvalue;
    }
}
