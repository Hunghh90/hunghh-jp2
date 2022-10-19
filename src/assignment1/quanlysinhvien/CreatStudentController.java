package assignment1.quanlysinhvien;

import assignment1.Main;
import assignment1.helper.Connertor;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CreatStudentController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            String sql_txt = "insert into students(name,email,tel) values(?,?,?)";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(email);
            arr.add(tel);
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
        Parent quanLySach = FXMLLoader.load(getClass().getResource("../quanlysinhvien/form.fxml"));
        Main.rootStage.setTitle("QuanLySach");
        Main.rootStage.setScene(new Scene(quanLySach, 800,600));
    }
}
