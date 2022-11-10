package assignment1.quanlymuonsach;

import assignment1.*;
import assignment1.dao.impls.BookRentRepository;
import assignment1.dao.impls.BookReposittory;
import assignment1.dao.impls.StudentRepository;
import assignment1.enums.RepositoryType;
import assignment1.factory.RepositoryFactory;
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
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class BookStudentController implements Initializable {

    public ComboBox<Form> msBook;
    public ComboBox<Student> msStudent;
    public DatePicker msNgayTra;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        BookReposittory br = new BookReposittory();
        ObservableList<Form> ls = FXCollections.observableArrayList();
        BookReposittory br = (BookReposittory) RepositoryFactory.creatRepository(RepositoryType.BOOk);
        ls.addAll(br.all());
        msBook.setItems(ls);
//        StudentRepository br1 = new StudentRepository();
        ObservableList<Student> lsv = FXCollections.observableArrayList();
        StudentRepository br1 = (StudentRepository)RepositoryFactory.creatRepository(RepositoryType.STUDENT);
        lsv.addAll(br1.all());
        msStudent.setItems(lsv);

    }

    public void submit(ActionEvent actionEvent) {
        try {
            Form selected =  msBook.getSelectionModel().getSelectedItem();
            Student selected1 = msStudent.getSelectionModel().getSelectedItem();
            LocalDate dp = msNgayTra.getValue();
            BookRentRepository br = new BookRentRepository();
            ArrayList<BookRent> ls = new ArrayList<>();
            ls.addAll(br.all());

            BookRent br1 = new BookRent(selected.getId(), selected1.getId());

            if(br.create(br1)){
                back();
            }else {
                System.out.println("asdasdadaszdxsdxas");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public void back()throws Exception{
        Parent addBook = FXMLLoader.load(getClass().getResource("../quanlymuonsach/form.fxml"));
        Main.rootStage.setTitle("addBook");
        Main.rootStage.setScene(new Scene(addBook, 800,600));
    }


    public void setMsBook(ComboBox<Form> msBook) {
        this.msBook = msBook;
    }

    public ComboBox<Student> getMsStudent() {
        return msStudent;
    }

    public ComboBox<Form> getMsBook() {
        return msBook;
    }

    public void setMsStudent(ComboBox<Student> msStudent) {
        this.msStudent = msStudent;
    }
}
