package practiceExamJava2.student.list;

import hotel.Main;
import hotel.dao.impls.RoomRepository;
import hotel.entities.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import practiceExamJava2.dao.impls.StudentRepository;
import practiceExamJava2.entities.Student;
import practiceExamJava2.enums.RepoType;
import practiceExamJava2.factory.RepositoryFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TableView<Student> studentview;
    public TableColumn<Student,String> studentid;
    public TableColumn<Student,String> studentname;
    public TableColumn<Student,String> address;
    public TableColumn<Student,String> phone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    studentid.setCellValueFactory(new PropertyValueFactory<>("studentId"));
    studentname.setCellValueFactory(new PropertyValueFactory<>("studentName"));
    address.setCellValueFactory(new PropertyValueFactory<>("address"));
    phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        ObservableList<Student> ls = FXCollections.observableArrayList();
        StudentRepository r = (StudentRepository)RepositoryFactory.creStudentRepository(RepoType.STUDENT);
        ls.add(r.all());
    studentview.setItems(ls);
    }

    public void add(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("../add/add.fxml"));
        Scene listScene = new Scene(listPage, 600, 400);
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(listScene);
    }

    public void exit(ActionEvent actionEvent) {
    }

    public void save(ActionEvent actionEvent) {
    }
}
