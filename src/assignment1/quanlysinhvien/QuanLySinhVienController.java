package assignment1.quanlysinhvien;

import assignment1.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class QuanLySinhVienController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student,Integer> ID;
    public TableColumn<Student,String> Name;
    public TableColumn<Student,String> Email;
    public TableColumn<Student,String> Tel;

    public final static String connectionString = "jdbc:mysql://localhost:3306/demojp2";
    public final static String user = "root";
    public final static String pwd = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        Email.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        Tel.setCellValueFactory(new PropertyValueFactory<Student,String>("tel"));

        ObservableList<Student> lsv = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from students";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student b = new Student(id,name,email,tel);
                lsv.add(b);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudents.setItems(lsv);
        }


    }

    public void Add(){

    }

    public void Back(){

    }
}
