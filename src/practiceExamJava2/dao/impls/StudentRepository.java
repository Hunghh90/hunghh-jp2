package practiceExamJava2.dao.impls;

import hotel.helper.Connector;
import practiceExamJava2.dao.interfaces.PracticeExamRepository;
import practiceExamJava2.entities.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements PracticeExamRepository<Student> {

    @Override
    public ArrayList all() {
        ArrayList<Student> ls = new ArrayList<>();
            try {
                String sql_txt = "select * from students";
                Connector conn = Connector.getInstance();
                ResultSet rs = conn.query(sql_txt);
                while (rs.next()){
                    String studentId = rs.getString("id");
                    String studentName = rs.getString("name");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");

                    Student c = new Student(studentId,studentName,address,phone);
                    ls.add(c);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        return ls;

        }


    @Override
    public boolean create(Student student) {
        ArrayList<Student> lsname = new ArrayList<>();
        try {
            String sql_txt = "insert into students(id,name,address,phone) values(?,?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getStudentId());
            arr.add(student.getStudentName());
            arr.add(student.getAddress());
            arr.add(student.getPhone());

            if (conn.execute(sql_txt, arr)) {
                return true;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(Student student) {
        return false;
    }
}
