package Tema_Exceptions;


import java.time.LocalDate;
import java.time.Period;

public class Student {
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String gender;
        private String id;


        public Student(String firstName, String lastName, Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth, String gender, String id) {
            if (firstName == null) {
                throw new IllegalArgumentException("Everybody needs to have a first name");
            }
            this.firstName = firstName;

            if (lastName == null) {
                throw new IllegalArgumentException("Everybody needs to have a last name");
            }
            this.lastName = lastName;

            if (yearOfBirth == null ||
                    monthOfBirth == null ||
                    dayOfBirth == null ||
                    yearOfBirth < 1900 ||
                    yearOfBirth > (LocalDate.now().getYear() - 18)) {
                throw new IllegalArgumentException("The age is not suitable");
            }
            this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);

            if (gender == null ||
                    (!gender.equalsIgnoreCase("F") && !gender.equalsIgnoreCase("M"))) {
                throw new IllegalArgumentException("Everybody needs to have a gender (f/F/m/M)");
            }
            this.gender = gender;

            if (id == null) {
                throw new IllegalArgumentException("Everybody needs to have an id");
            }
            this.id = id;
        }

        public Integer getAge() {
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getGender() {
            return gender;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Student {" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                    ", gender='" + gender + '\'' +
                    ", id='" + id + '\'' +
                    "}";
        }
    }

