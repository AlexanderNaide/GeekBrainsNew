package ru.gb.spring_mvc.ClassWork_Boot.BootApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_mvc.ClassWork_Boot.BootApp.Sevices.StudentService;
import ru.gb.spring_mvc.model.Student;

import java.util.List;

@RestController                                                    // - Эта аннотация означает, что ВСЕ методы в этом контроллере будут @ResponseBody без явного указания самого @ResponseBody
public class StudentController {

    private StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PostMapping("/addStudent")
    public void addStudentForm(@RequestBody Student student){
        service.addStudent(student);
    }
}
