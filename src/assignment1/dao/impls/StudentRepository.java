package assignment1.dao.impls;

import assignment1.Student;
import assignment1.dao.interfaces.IStudentRepository;
import assignment1.helper.Connertor;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements IStudentRepository {
    @Override
    public ArrayList<Student> all() {
        ArrayList<Student> st = new ArrayList<>();
        try {
            String sql_txt = "select * from students";
            Connertor conn = Connertor.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student s = new Student(id,name,email,tel);
                st.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return st;
    }

    @Override
    public Boolean create(Student student) {
        try {
            String sql_txt = "insert into students(name,email,tel) values(?,?,?)";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getTel());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public Boolean update(Student student) {
        try {
            String sql_txt = "update students set name =?, email = ?, tel = ? where id = ?";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getTel());
            arr.add(student.getId());
            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public Boolean delete(Student student) {
        try {

            String sql_txt = "delete from students where id=?";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getId());
            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }
}
