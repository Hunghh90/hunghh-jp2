package assignment1.quanlysach;

import assignment1.Form;
import assignment1.Main;
import assignment1.dao.impls.BookReposittory;
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
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class QuanLySachController implements Initializable {
    public TableView<Form> tbBooks;
    public TableColumn<Form,Integer> ID;
    public TableColumn<Form,String> Name;
    public TableColumn<Form,String> Author;
    public TableColumn<Form,Integer> Quantity;
    public TableColumn<Form, Button> Action;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory<Form,Integer>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<Form,String>("name"));
        Author.setCellValueFactory(new PropertyValueFactory<Form,String>("author"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Form,Integer>("qty"));
        Action.setCellValueFactory(new PropertyValueFactory<Form,Button>("edit"));

        ObservableList<Form> ls = FXCollections.observableArrayList();
        BookReposittory br = new BookReposittory();
        ls.addAll(br.all());
        tbBooks.setItems(ls);

    }

    public void Add()throws Exception{
        Parent addBook = FXMLLoader.load(getClass().getResource("../quanlysach/creatbook.fxml"));
        Main.rootStage.setTitle("addBook");
        Main.rootStage.setScene(new Scene(addBook, 800,600));
    }

    public void Back()throws Exception{
        Parent addBook = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("addBook");
        Main.rootStage.setScene(new Scene(addBook, 800,600));
    }
}
