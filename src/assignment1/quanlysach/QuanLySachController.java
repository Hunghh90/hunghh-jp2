package assignment1.quanlysach;

import assignment1.Form;
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

public class QuanLySachController implements Initializable {
    public TableView<Form> tbBooks;
    public TableColumn<Form,Integer> ID;
    public TableColumn<Form,String> Name;
    public TableColumn<Form,String> Author;
    public TableColumn<Form,Integer> Quantity;

    public final static String connectionString = "jdbc:mysql://localhost:3306/demojp2";
    public final static String user = "root";
    public final static String pwd = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory<Form,Integer>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<Form,String>("name"));
        Author.setCellValueFactory(new PropertyValueFactory<Form,String>("author"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Form,Integer>("qty"));

        ObservableList<Form> ls = FXCollections.observableArrayList();
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection(connectionString,user,pwd);
           Statement statement = conn.createStatement();
           String sql_txt = "select * from books";
           ResultSet rs = statement.executeQuery(sql_txt);
           while (rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String author = rs.getString("author");
               int qty = rs.getInt("qty");
               Form b = new Form(id,name,author,qty);
               ls.add(b);
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }finally {
           tbBooks.setItems(ls);
       }


    }

    public void Add(){

    }

    public void Back(){

    }
}
