package assignment1.quanlysinhvien;

import assignment1.Form;
import assignment1.Main;
import assignment1.Student;
import assignment1.dao.impls.BookReposittory;
import assignment1.dao.impls.StudentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentEditController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public static Student editedStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedStudent !=null){
            txtName.setText(editedStudent.getName());
            txtEmail.setText(editedStudent.getEmail());
            txtTel.setText(editedStudent.getTel());
        }
    }

    public void submit() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            editedStudent.setName(name);
            editedStudent.setEmail(email);
            editedStudent.setTel(tel);
            StudentRepository br = new StudentRepository();
            if(br.update(editedStudent)){
                back();
            }else{
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void back()throws Exception {
        Parent quanLySach = FXMLLoader.load(getClass().getResource("../quanlysinhvien/form.fxml"));
        Main.rootStage.setTitle("QuanLySinhVien");
        Main.rootStage.setScene(new Scene(quanLySach, 800,600));
    }

    public void delete(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Student");
            alert.setHeaderText("Ban chac chan muon xoa sinh vien: "+editedStudent.getName());
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get() == ButtonType.OK){
                StudentRepository br = new StudentRepository();
                if(br.delete(editedStudent)){
                    back();
                }else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e){

        }
    }
}
