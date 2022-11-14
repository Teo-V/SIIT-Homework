package Tema_Exceptions;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        String o1LastName = o1.getLastName();
        String o2LastName = o2.getLastName();
        return o1LastName.compareTo(o2LastName);
    }
}
