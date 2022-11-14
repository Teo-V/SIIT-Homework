package Tema_Exceptions;

public class StudentDuplicateException extends RuntimeException {

    public StudentDuplicateException(String s) {
        super(s);
    }
}