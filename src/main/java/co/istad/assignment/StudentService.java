package co.istad.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final List<Student> studentsList;
    private final List<Student> students;

    public Student insertStudent(Student student){
        if (student.getId().equals(studentsList.get(studentsList.size()-1).getId())){
            System.out.println("Student id already exists" + student.getId());
            return null;
        }
        studentsList.add(student);
        return student;
    }

    public List<Student> selectAllStudents(){
        return studentsList;
    }

        public Student selectStudentById(int id){
            return studentsList.stream()
                    .filter(student -> student.getId().equals(id))
                    .findFirst().get();
        }

    public Student updateStudent(int id , Student updatedStudent){
        for (int i = 0; i<studentsList.size(); i++){
            Student student = studentsList.get(i);
            if (student.getId().equals(id)){
                student.setFullName(updatedStudent.getFullName());
                student.setGender(updatedStudent.getGender());
                student.setScore(updatedStudent.getScore());
                return student;
            }
        }
        return null;
    }

    public int deleteStudent(int id){
        for (int i = 0; i<studentsList.size(); i++){
            Student student = studentsList.get(i);
            if (student.getId().equals(id)){
                studentsList.remove(i);
                return 1;
            }
        }
        return 0;
    }
}

