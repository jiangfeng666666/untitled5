package jdbcDAO;

import java.sql.Connection;
import java.util.ArrayList;

public interface studentDAO {
    void insert(Connection connection,student stu);
    void delete(Connection connection,int id );
    void updata(Connection connection,student sut,int id);
    student select(Connection connection,int id);
    ArrayList<student> SumSelect(Connection connection);
    long count(Connection connection);
}
