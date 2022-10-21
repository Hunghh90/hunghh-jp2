package assignment1.dao.interfaces;

import assignment1.Form;


import java.util.ArrayList;

public interface IBookRepository {
    ArrayList<Form> all();
    Boolean create(Form book);
    Boolean update(Form book);
    Boolean delete(Form book);
    Form findOne(Integer id);
}
