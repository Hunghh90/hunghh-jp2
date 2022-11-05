package assignment1.quanlymuonsach;

import assignment1.BookRent;
import assignment1.Form;
import assignment1.Main;
import assignment1.dao.impls.BookRentRepository;
import assignment1.dao.impls.BookReposittory;
import assignment1.enums.RepositoryType;
import assignment1.factory.RepositoryFactory;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class QuanLyMuonSachController implements Initializable {


    public TableColumn<BookRent, Integer> ID;
    public TableColumn<BookRent, String> StudentName;
    public TableColumn<BookRent, String> BookName;
    public TableColumn<BookRent, Date> Depc;
    public TableColumn<BookRent, Integer> Action;
    public TableView<BookRent> tbBookRents;

    public void Add()throws Exception{
        Parent quanLySinhVien = FXMLLoader.load(getClass().getResource("../quanlymuonsach/bookstudent.fxml"));
        Main.rootStage.setTitle("QuanLySinhVien");
        Main.rootStage.setScene(new Scene(quanLySinhVien, 800,600));
    }
    public void Back()throws Exception{
        Parent quanLySinhVien = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("QuanLySinhVien");
        Main.rootStage.setScene(new Scene(quanLySinhVien, 800,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        StudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        BookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        Depc.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        Action.setCellValueFactory(new PropertyValueFactory<>("status"));
        BookRentRepository br = (BookRentRepository) RepositoryFactory.creatRepository(RepositoryType.BOOKRENT);
        tbBookRents.getItems().addAll(br.all());

    }
}
