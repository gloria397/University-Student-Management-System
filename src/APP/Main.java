package APP;

import LAB1.Courses;
import LAB1.Student;
import DAO.CourseDAO;
import DAO.EnrollmentDAO;
import DAO.StudentDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        while (true) {
            printMenu();

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Email: ");
                        String email = sc.nextLine().trim();
                        System.out.print("GPA (0 - 4): ");
                        double gpa = Double.parseDouble(sc.nextLine().trim());

                        if (name.isEmpty() || email.isEmpty()) {
                            System.out.println("Name and email cannot be empty.");
                        } else if (gpa < 0 || gpa > 4) {
                            System.out.println("GPA must be between 0 and 4.");
                        } else {
                            studentDAO.addStudent(name, email, gpa);
                            System.out.println("Student added.");
                        }
                    }
                    case 2 -> {
                        for (Student s : studentDAO.getAllStudents()) {
                            System.out.println(s);
                        }
                    }
                    case 3 -> {
                        System.out.print("Student id to remove: ");
                        studentDAO.deleteStudent(Integer.parseInt(sc.nextLine().trim()));
                        System.out.println("Done.");
                    }
                    case 4 -> {
                        System.out.print("Course name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Credits: ");
                        int credits = Integer.parseInt(sc.nextLine().trim());

                        if (name.isEmpty() || credits <= 0) {
                            System.out.println("Enter a course name and credits above 0.");
                        } else {
                            courseDAO.addCourse(name, credits);
                            System.out.println("Course added.");
                        }
                    }
                    case 5 -> {
                        for (Courses c : courseDAO.getAllCourses()) {
                            System.out.println(c);
                        }
                    }
                    case 6 -> {
                        System.out.print("Course id to remove: ");
                        courseDAO.deleteCourse(Integer.parseInt(sc.nextLine().trim()));
                        System.out.println("Done.");
                    }
                    case 7 -> {
                        System.out.print("Student id: ");
                        int studentId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Course id: ");
                        int courseId = Integer.parseInt(sc.nextLine().trim());
                        enrollmentDAO.enroll(studentId, courseId);
                        System.out.println("Student enrolled.");
                    }
                    case 8 -> {
                        enrollmentDAO.printStudentsWithCourses();
                    }
                    case 9 -> {
                        System.out.print("Enrollment id: ");
                        int enrollmentId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("New course id: ");
                        int newCourseId = Integer.parseInt(sc.nextLine().trim());
                        enrollmentDAO.updateEnrollment(enrollmentId, newCourseId);
                        System.out.println("Enrollment updated.");
                    }
                    case 0 -> {
                        System.out.println("Exiting.");
                        return;
                    }
                    default -> System.out.println("Invalid input from the menu");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input: please enter a number.");
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("""

                 University Student Management System
                1. Add student
                2. List students
                3. Remove student
                4. Add course
                5. List courses
                6. Remove course
                7. Enroll student in course
                8. View students with their courses
                9. Update an enrollment
                0. Exit
                """);
        System.out.print("Choose: ");
    }
}