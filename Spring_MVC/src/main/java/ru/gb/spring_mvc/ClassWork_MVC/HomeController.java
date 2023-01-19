package ru.gb.spring_mvc.ClassWork_MVC;

import jakarta.servlet.http.HttpServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@ResponseBody - Когда мы не используем этот тэг: ...
@RequestMapping("/home")
public class HomeController extends HttpServlet{

    @GetMapping("")
    public String home(){
        return "classwork/home";       // ... методы возвращают не тело ответа, страницу шаблона, которая будет ответом. Страница с этим именем должна лежать в resources/templates/... то есть resources/templates/home.html
    }

    // Чтобы передать в html страницу какието переменные добавляем в параметры объект Model, которому добавляем нужные переменные в виде атрибутов
    @GetMapping("/{name}")
    public String homeName(Model model, @PathVariable String name){
        model.addAttribute("name", name);
        return "classwork/home2";
    }
}
