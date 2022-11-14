package Tema_Exceptions;

import java.time.LocalDate;
import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Student> {

    @Override
    public int compare(Tema_Exceptions.Student o1, Student o2) {
        LocalDate o1BirthDay = o1.getDateOfBirth();
        LocalDate o2BirthDay = o2.getDateOfBirth();
        return o1BirthDay.compareTo(o2BirthDay);

    }
}
