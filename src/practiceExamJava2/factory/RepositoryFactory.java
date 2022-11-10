package practiceExamJava2.factory;


import practiceExamJava2.dao.impls.StudentRepository;
import practiceExamJava2.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory(){

    }
    public static StudentRepository creStudentRepository(RepoType type){
        switch (type){

            case STUDENT:return new StudentRepository();

            default: throw new IllegalArgumentException("thiếu tham số ");
        }
    }
}
