package ru.gb.spring_mvc.ClassWork_Boot.BootApp.Repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.gb.spring_mvc.model.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> list;

    @PostConstruct
    public void init(){
        list = new ArrayList<>();
        list.add(new Student("Max", 30));
        list.add(new Student("Mad", 60));
        list.add(new Student("Bob", 90));
        list.add(new Student("Priti", 70));
        list.add(new Student("Sveta", 30));
    }

    public void addStudent(Student student){
        list.add(student);
    }

    public Student findById(final Long ig){
        return list.stream().filter(s -> s.getId().equals(ig)).findFirst().orElseThrow(RuntimeException::new);
    }

    public List<Student> getList(){
        return list;
    }

    public void deleteById(Long id){
        list.removeIf(s -> s.getId().equals(id));
    }
}
