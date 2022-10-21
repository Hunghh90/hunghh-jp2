package assignment1.quanlysach;

import assignment1.Form;
import assignment1.Main;
import assignment1.dao.impls.BookReposittory;
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

public class BookEditController implements Initializable {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public static Form editedBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedBook !=null){
            txtName.setText(editedBook.getName());
            txtAuthor.setText(editedBook.getAuthor());
            txtQty.setText(editedBook.getQty().toString());
        }
    }

    public void submit() {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            editedBook.setName(name);
            editedBook.setAuthor(author);
            editedBook.setQty(qty);
            BookReposittory br = new BookReposittory();
            if(br.update(editedBook)){
                back();
            }else{
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void back()throws Exception {
        Parent quanLySach = FXMLLoader.load(getClass().getResource("../quanlysach/form.fxml"));
        Main.rootStage.setTitle("QuanLySach");
        Main.rootStage.setScene(new Scene(quanLySach, 800,600));
    }

    public void delete(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Book");
            alert.setHeaderText("Ban chac chan muon xoa sach: "+editedBook.getName());
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get() == ButtonType.OK){
                BookReposittory br = new BookReposittory();
                if(br.delete(editedBook)){
                    back();
                }else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e){

        }
    }
}
