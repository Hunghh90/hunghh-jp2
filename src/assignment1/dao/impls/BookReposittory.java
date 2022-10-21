package assignment1.dao.impls;

import assignment1.Form;
import assignment1.dao.interfaces.IBookRepository;
import assignment1.helper.Connertor;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BookReposittory implements IBookRepository {
    @Override
    public ArrayList<Form> all() {
        ArrayList<Form> ls = new ArrayList<>();
        try {

            String sql_txt = "select * from books";
            Connertor conn = Connertor.getInstance();
            ResultSet rs = conn.query(sql_txt);
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
        }
        return ls;
    }

    @Override
    public Boolean create(Form book) {
        try {
            String sql_txt = "insert into books(name,author,qty) values(?,?,?)";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getName());
            arr.add(book.getAuthor());
            arr.add(book.getQty());
            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        }catch (Exception e){

        }

        return false;
    }

    @Override
    public Boolean update(Form book) {
        try {
            String sql_txt = "update books set name =?, author = ?, qty = ? where id = ?";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getName());
            arr.add(book.getAuthor());
            arr.add(book.getQty());
            arr.add(book.getId());
            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        }catch (Exception e){
        System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public Boolean delete(Form book) {
        try {

            String sql_txt = "delete from books where id=?";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getId());
            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public Form findOne(Integer id) {
        try {
            String sql_txt = "select * from books where id=?";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()) {
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                return new Form(Id,name,author,qty);
            }
        }catch (Exception e){

        }
        return null;

    }
}
