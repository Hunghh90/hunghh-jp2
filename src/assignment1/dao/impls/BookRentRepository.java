package assignment1.dao.impls;

import assignment1.BookRent;
import assignment1.Form;
import assignment1.dao.interfaces.IRepository;
import assignment1.helper.Connertor;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BookRentRepository implements IRepository<BookRent> {
    @Override
    public ArrayList<BookRent> all() {
        ArrayList<BookRent> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from bookrents";
            Connertor conn = Connertor.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                ls.add(new BookRent(
                        rs.getInt("id"),
                        rs.getInt("bookId"),
                        rs.getInt("studentId"),
                        rs.getDate("rentDate"),
                        rs.getDate("expiredDate"),
                        rs.getInt("status")
                ));
            }
        }catch (Exception e){
        }
        return ls;
    }

    @Override
    public boolean create(BookRent bookRent) {
        try {
            String sql_txt = "insert into bookrents(bookId,studentId) values(?,?)";
            Connertor conn = Connertor.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(bookRent.getBookId());
            arr.add(bookRent.getStudentId());

            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        return false;
    }

    @Override
    public boolean update(BookRent bookRent) {
        return false;
    }

    @Override
    public boolean delete(BookRent bookRent) {
        return false;
    }

    @Override
    public BookRent findOne(Integer id) {
        return null;
    }
}
