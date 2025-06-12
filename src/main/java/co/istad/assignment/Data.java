package co.istad.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Data {

    @Bean
    public List<Student> students(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Polin","M",90));
        students.add(new Student(2,"Devith","M",90));
        students.add(new Student(3,"Mony","M",80));
        students.add(new Student(4,"Panharath","M",80));
        students.add(new Student(5,"Bunvarn","F",75));
        students.add(new Student(6,"Rotha","F",75));
        students.add(new Student(7,"ReakSmey","F",75));
        students.add(new Student(8,"Samatra","F",75));
        students.add(new Student(9,"Saman","F",75));
        students.add(new Student(10,"Dara01","F",75));

        return students;
    }
}
