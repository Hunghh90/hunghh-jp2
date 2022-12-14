package assignment1.quanlysinhvien;

import assignment1.Main;
import assignment1.Student;
import assignment1.dao.impls.BookReposittory;
import assignment1.dao.impls.StudentRepository;
import assignment1.enums.RepositoryType;
import assignment1.factory.RepositoryFactory;
import assignment1.helper.Connertor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    public TableColumn<Student, Button> Action;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        Email.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        Tel.setCellValueFactory(new PropertyValueFactory<Student,String>("tel"));
        Action.setCellValueFactory(new PropertyValueFactory<Student,Button>("edit"));

        ObservableList<Student> lsv = FXCollections.observableArrayList();
        StudentRepository s = (StudentRepository) RepositoryFactory.creatRepository(RepositoryType.STUDENT);

                lsv.addAll(s.all());
            tbStudents.setItems(lsv);

    }

    public void Add()throws Exception{
        Parent addBook = FXMLLoader.load(getClass().getResource("../quanlysinhvien/creatstudent.fxml"));
        Main.rootStage.setTitle("AddStudent");
        Main.rootStage.setScene(new Scene(addBook, 800,600));
    }

    public void Back()throws Exception{
        Parent addBook = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("addBook");
        Main.rootStage.setScene(new Scene(addBook, 800,600));
    }
}
