package assignment1.quanlysach;

import assignment1.Main;
import assignment1.helper.Connertor;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.awt.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CreatBookController {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            String sql_txt = "insert into books(name,author,qty) values(?,?,?)";
            Connertor conn = new Connertor();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(author);
            arr.add(qty);
            if(conn.execute(sql_txt,arr)){
                back();
            }else{
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void back()throws Exception{
        Parent quanLySach = FXMLLoader.load(getClass().getResource("../quanlysach/form.fxml"));
        Main.rootStage.setTitle("QuanLySach");
        Main.rootStage.setScene(new Scene(quanLySach, 800,600));
    }
}
