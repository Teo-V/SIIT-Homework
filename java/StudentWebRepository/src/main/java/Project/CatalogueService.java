package Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {

    @Autowired
    public CatalogueService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    private final StudentsRepository studentsRepository;
    public String createStudentCatalogue(){
        List<Student> studentListToBeProcessed = studentsRepository.getStudents();
        String result1 = "";

        for (Student student: studentListToBeProcessed ) {
            result1 = result1.concat(student.getFirstName()).concat(" ").concat(student.getLastName().concat("<br></br>"));
        }

        List<Catalog> studentListOfGrades=studentsRepository.getGrades();
        String result2 = "";
        for(Catalog grade: studentListOfGrades){
            result2=result2.concat(grade.getFirstGrade().concat(grade.getSecondGrade()).concat(grade.getThirdGrade()).concat(grade.getForthGrade()).concat(grade.getAverage()).concat("<br></br>"));
        }
        return result1+result2 ;
    }

}