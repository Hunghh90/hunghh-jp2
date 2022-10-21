package assignment1.quanlymuonsach;

import assignment1.Form;
import assignment1.Main;
import assignment1.Student;
import assignment1.dao.impls.BookReposittory;
import assignment1.dao.impls.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class BookStudentController implements Initializable {

    public ComboBox<Form> msBook;
    public ComboBox<Student> msStudent;
    public DatePicker msNgayTra;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookReposittory br = new BookReposittory();
        ObservableList<Form> ls = FXCollections.observableArrayList();
        ls.addAll(br.all());
        msBook.setItems(ls);
        StudentRepository br1 = new StudentRepository();
        ObservableList<Student> lsv = FXCollections.observableArrayList();
        lsv.addAll(br1.all());
        msStudent.setItems(lsv);
    }

    public void submit(ActionEvent actionEvent) {
        Form selected =  msBook.getSelectionModel().getSelectedItem();
        Student selected1 = msStudent.getSelectionModel().getSelectedItem();
        LocalDate dp = msNgayTra.getValue();
        System.out.println(selected.getName());
        System.out.println(selected1.getName());
        System.out.println(dp);

    }
    public void back()throws Exception{
        Parent addBook = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("addBook");
        Main.rootStage.setScene(new Scene(addBook, 800,600));
    }
}
