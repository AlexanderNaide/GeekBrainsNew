package ru.gb.spring_mvc.ClassWork_MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.spring_mvc.model.Student;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {

    @GetMapping("/all")
    public String getAllStudents(Model model){
        List<Student> students = List.of(
                new Student(),
                new Student(),
                new Student(),
                new Student(),
                new Student()
        );

        model.addAttribute("students", students);

        return "classwork_mvc/students";
    }




}
