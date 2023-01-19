package ru.gb.spring_mvc.ClassWork_Boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_mvc.ClassWork_Boot.BootApp.Repositories.StudentRepository;
import ru.gb.spring_mvc.model.Student;

@Controller
@RequestMapping("/boot")
//@RestController                                                    // - Эта аннотация означает, что ВСЕ методы в этом контроллере будут @ResponseBody без явного указания самого @ResponseBody
public class MainController {

    private StudentRepository repository;

    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/printStudent")
    @ResponseBody                                                    // @ResponseBody - отправляем тело запроса
    public void printStudent(@RequestBody Student student){          // @RequestBody - принимаем в теле запроса, в данном случае парсится json
        System.out.println(student.getName());
    }

    @PostMapping("/getStudent")
    @ResponseBody
    public Student getStudent(@RequestBody Student student){
        student.setName(student.getName() + " student");
        return student;
    }

    @GetMapping("/stud")
    public String studentForm(){
        return "classwork_boot/form";
    }

    @GetMapping("/stud_add")
    public String addStudentForm(@RequestParam Long id, @RequestParam String name){
        repository.addStudent(new Student(name));
        return "redirect:/boot/all_stud";
    }

    @GetMapping("/all_stud")
    public String getAllStudents(Model model){
        model.addAttribute("students", repository.getList());
        return "classwork_boot/students";
    }

}
