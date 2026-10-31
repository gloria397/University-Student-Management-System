package LAB1;

import java.util.*;

public class UniversityManager {

    private List<Student> students = new ArrayList<>();

    private Map<Courses, Set<Student>> courseRosters = new HashMap<>();

    private Map<Courses, Instructor> instructorAssignments = new HashMap<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void enrollStudent(Courses course, Student student) {

        courseRosters.putIfAbsent(course, new HashSet<>());

        courseRosters.get(course).add(student);
    }

    public void displayCourseRoster(Courses course) {

        Set<Student> roster = courseRosters.get(course);

        if (roster == null || roster.isEmpty()) {
            System.out.println("No students enrolled in this course.");
            return;
        }

        for (Student student : roster) {
            System.out.println(student);
        }
    }


    public void assignInstructor(Courses course, Instructor instructor) {
        instructorAssignments.put(course, instructor);
    }


    public void displayAssignments() {
        instructorAssignments.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println("Course: " + entry.getKey());
                    System.out.println("Instructor: " + entry.getValue());
                });
    }


    public List<Student> getStudents() {
        return students;
    }
}