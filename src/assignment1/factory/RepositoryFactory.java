package assignment1.factory;

import assignment1.dao.impls.BookRentRepository;
import assignment1.dao.impls.BookReposittory;
import assignment1.dao.impls.StudentRepository;
import assignment1.dao.interfaces.IRepository;
import assignment1.enums.RepositoryType;

public class RepositoryFactory {
    private RepositoryFactory() {
    }
    public static IRepository creatRepository(RepositoryType type){
        switch (type){
            case BOOk: return  new BookReposittory();
            case BOOKRENT: return  new BookRentRepository();
            case STUDENT: return  new StudentRepository();
            default: throw new IllegalArgumentException("Thieu tham so");
        }
    }
}
