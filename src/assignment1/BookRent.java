package assignment1;

import assignment1.dao.impls.BookReposittory;
import assignment1.dao.impls.StudentRepository;
import assignment1.enums.RepositoryType;
import assignment1.factory.RepositoryFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class BookRent {

    public Integer id;
    public Integer bookId;
    public Integer studentId;
   public Date rentDate;
    public Date expiredDate;
    public Integer status;
    public String bookName;
    public String studentName;

    public static ArrayList<BookRent> bookRent;
    public BookRent() {
    }

    public BookRent(Integer bookId, Integer studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
    }

    public BookRent(Integer id, Integer bookId, Integer studentId, Date rentDate, Date expiredDate, Integer status) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.rentDate = rentDate;
        this.expiredDate = expiredDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Form book(){
        return ((BookReposittory) RepositoryFactory.creatRepository(RepositoryType.BOOk)).findOne(this.getBookId());
    }
    public Student student(){
        return ((StudentRepository) RepositoryFactory.creatRepository(RepositoryType.STUDENT)).findOne(this.getStudentId());
    }
    public String toString(){
        return book().getName()+ student().getName();

    }

    public String getBookName() {
        return this.book().getName();
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentName() {
        return this.student().getName();
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
