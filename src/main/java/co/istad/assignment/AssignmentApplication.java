package co.istad.assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

    private final StudentService studentService;

    public AssignmentApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;

        while (true) {
            System.out.println("""
                    ======================
                    Student Manage Student 
                    ======================
                    """);
            System.out.print("[+] Insert Option: ");
            opt = scanner.nextInt();

            switch (opt) {
                case 1 -> {
                    System.out.println("""
                            ===== Insert New Student ====
                            """);
                    System.out.print("[+] Insert Id: ");
                    Integer id = scanner.nextInt();
                    System.out.print("[+] Insert FullName: ");
                    String name = scanner.next();
                    System.out.print("[+] Insert Gender: ");
                    String gender = scanner.next();
                    System.out.print("[+] Insert Score: ");
                    Double score = scanner.nextDouble();

                    Student newStudent = Student.builder()
                            .id(id)
                            .fullName(name)
                            .gender(gender)
                            .score(score)
                            .build();
                    studentService.insertStudent(newStudent);
                    System.out.println("Student Inserted Successfully!");
                }
                case 2 -> {
                    System.out.println("""
                            ===== Select All Student =====
                            """);
                    studentService.selectAllStudents()
                            .forEach(student -> {
                                System.out.println("Student Id: " + student.getId());
                                System.out.println("Student FullName: " + student.getFullName());
                                System.out.println("Student Gender: " + student.getGender());
                                System.out.println("Student Score: " + student.getScore());
                                System.out.println("=========================================");
                            });
                }
                case 3 -> {
                    System.out.println("""
                            ===== Select Student By Id =====
                            """);
                    System.out.print("[+] Insert Id Student : ");
                    Integer id = scanner.nextInt();
                    Student student = studentService.selectStudentById(id);
                    if (student != null) {
                        System.out.println("Student Id: " + student.getId());
                        System.out.println("Student FullName: " + student.getFullName());
                        System.out.println("Student Gender: " + student.getGender());
                        System.out.println("Student Score: " + student.getScore());
                    } else {
                        System.out.println("Student Not Found!");
                    }
                }
                case 4 -> {
                    System.out.println("""
                            ===== Update Student By Id =====
                            """);
                    System.out.print("[+] Insert Id Student : ");
                    Integer id = scanner.nextInt();
                    Student student = studentService.selectStudentById(id);
                    if (student != null) {
                        System.out.print("[+] Update FullName Student : ");
                        String fullName = scanner.next();
                        System.out.print("[+] Update Gender Student : ");
                        String gender = scanner.next();
                        System.out.print("[+] Update Score Student : ");
                        Double score = scanner.nextDouble();

                        Student updateStudent = Student.builder()
                                .fullName(fullName)
                                .gender(gender)
                                .score(score)
                                .build();
                        studentService.updateStudent(id, updateStudent);
                        System.out.println("Student Updated Successfully!");
                    }
                }
                case 5 -> {
                    System.out.println("""
                            ===== Delete Student By Id =====
                    """);
                    System.out.print("[+] Delete Id Student : ");
                    Integer id = scanner.nextInt();
                    Student student = studentService.selectStudentById(id);
                    if (student != null) {
                        System.out.println("Delete Student failed!");
                        return;
                    }
                    System.out.println("Student Deleted Successfully!");

                }
            }
        }
    }
}
