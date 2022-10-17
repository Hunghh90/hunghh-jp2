package assignment1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {

    public void quanLySach() throws Exception {
        Parent quanLySach = FXMLLoader.load(getClass().getResource("quanlysach/form.fxml"));
        Main.rootStage.setTitle("QuanLySach");
        Main.rootStage.setScene(new Scene(quanLySach, 800,600));
    }
    public void quanLySinhVien() throws Exception{
        Parent quanLySinhVien = FXMLLoader.load(getClass().getResource("quanlysinhvien/form.fxml"));
        Main.rootStage.setTitle("QuanLySinhVien");
        Main.rootStage.setScene(new Scene(quanLySinhVien, 800,600));
    }
    public void quanLyMuonSach(){

    }
}
