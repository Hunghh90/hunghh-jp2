package practiceExamJava2.dao.interfaces;

import java.util.ArrayList;

public interface PracticeExamRepository<S> {
    ArrayList<S> all();

    boolean create(S s);

    boolean update(S s);

    boolean delete(S s);

}
