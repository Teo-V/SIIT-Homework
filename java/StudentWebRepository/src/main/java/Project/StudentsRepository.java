package Project;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentsRepository {

    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student("Alexandru", "Ion");
        Student student2 = new Student("Roxana", "Banaga");
        Student student3 = new Student("Andreea", "Chirculescu");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        return studentList;
    }
    public List<Catalog> getGrades(){
        List<Catalog> studentGradesList=new ArrayList<>();
        Catalog grade1=new Catalog(2, 10 ,7 , 10);
        Catalog grade2=new Catalog(5, 9,8, 9);
        Catalog grade3=new Catalog(10, 9, 10,9 );

        studentGradesList.add(grade1);
        studentGradesList.add(grade2);
        studentGradesList.add(grade3);
        return studentGradesList;
    }

}