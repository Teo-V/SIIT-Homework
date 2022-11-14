package Tema_Exceptions;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class StudentManager {

    public static class StudentRepository {
        private static final Logger log = LogManager.getLogger(StudentRepository.class);
        private List<Student> students;
        private Map<String, Comparator<Student>> comparators;

        public StudentRepository() {
            students = new ArrayList<>();
            comparators = new HashMap<>();
            comparators.put("LastName", (Comparator<Student>) new LastNameComparator());
            comparators.put("BirthDate", new DateOfBirthComparator());
        }


        public void addStudent(Student studentToAdd) {
            if (studentToAdd == null) {
                throw new IllegalArgumentException("Student cannot be null");
            }
            Student studentInList = getById(studentToAdd.getId());
            if (studentInList != null) {
                log.log(Level.DEBUG, "Found duplicate: " + studentInList.getId());
                throw new StudentDuplicateException("Student already exists in the repository");
            }
            log.log(Level.INFO, "Adding student: " + studentToAdd);
            students.add(studentToAdd);
        }


        public Student getById(String id) {
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    return student;
                }
            }
            return null;
        }

        public List<Student> getAll() {
            return students;
        }

        public List<Student> getAll(String orderBy) {
            if (orderBy == null) {
                throw new IllegalArgumentException("Order criteria cannot be null");
            }

            Comparator<Student> studentComparator = comparators.get(orderBy);
            if (!comparators.containsKey(orderBy)) {
                throw new IllegalArgumentException("Order criteria is not part of: " + comparators.keySet());
            }
            List<Student> studentsToSort = new ArrayList<>(getAll());
            studentsToSort.sort(studentComparator);
            return studentsToSort;
        }


        public void deleteStudent(String id) {
            if (id == null) {
                throw new IllegalArgumentException("Enter the id");
            }
            Student studentToRemove = null;
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    studentToRemove = student;
                    break;
                }
            }
            log.log(Level.INFO, "Deleting student: " + studentToRemove);
            students.remove(studentToRemove);
        }

        public List<Student> retrieveStudentsSameAge(Integer age) {
            if (age == null || age < 0) {
                throw new IllegalArgumentException("Age should be a positive number");
            }
            List<Student> studentsSameAge = new ArrayList<>();
            for (Student student : students) {
                if (student.getAge().equals(age)) {
                    studentsSameAge.add(student);
                }
            }
            return studentsSameAge;
        }

        @Override
        public String toString() {
            return "Student repository is:" +
                    "\n" + students;
        }

        public void addComparator(String key, Comparator<Student> comparator) {
            comparators.put(key, comparator);
        }
    }
}
