package ru.gb.spring_mvc.ClassWork_Boot.BootApp.Sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_mvc.ClassWork_Boot.BootApp.Repositories.StudentRepository;
import ru.gb.spring_mvc.model.Student;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;
    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents(){
        return repository.getList();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void addStudent(Student student){
        repository.addStudent(student);
    }

}
