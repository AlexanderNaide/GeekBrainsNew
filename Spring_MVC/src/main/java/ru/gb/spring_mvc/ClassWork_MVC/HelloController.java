package ru.gb.spring_mvc.ClassWork_MVC;

import jakarta.servlet.http.HttpServlet;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController extends HttpServlet{


    //    @GetMapping - получить данные, аналог doGet метода (в тело get запроса обычно ничего полезного не зашивается, он ограничен по длине 4b)
    //    @PostMapping - обновить данные, аналог doPost метода (в тело post запроса можно зашивать например json, не ограничен по длине)
    //    @DeleteMapping - удалить данные, аналог doDelete метода
    //    @PutMapping - добавить данные, аналог doPut метода
    //    @PatchMapping - ой, даже хз, что-то там с перенаправлением с неопределенным путем, типа("/users/{username}"), аналог doTrace метода, кажется
    //    @RequestMapping(value = "/hello", method = RequestMethod.PUT) - универсальный способ задания мапинга с указанием метода обработки, но так лучше не делать - плохая читаемость

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, defaultValue = "World", name = "name.Arg") String name){


        // @RequestParam String name - при обращении к /hello ищется параметр ?name=Igor, без параметра работать не будет
        // @RequestParam(required = false) String name - если так, то параметр не обязательный, если его нет,
            // или имя не совпадает, метод все равно сработает, но вместо name будет null
        // @RequestParam(required = false, defaultValue = "World") String name - тоже, что и в предыдущем варианте,
            // только при отсутствие параметра name подставиться заданное значение по умолчанию ("World")
        // @RequestParam(required = false, defaultValue = "World", name = "name.Arg") String name -
            // Если явно указано имя параметра (name = "name.Arg") тогда параметр будет запрашиваться по нему,
            // если такого указания нет, тогда параметр будет запрашиваться по имени java переменной (String name)



        return "<h2>Hello " + name + "!</h2>";
    }

    @GetMapping("/helloname/{name}")
    public String helloName(@PathVariable String name){
        // когда так - параметр читается не из параметров(?name=Igor), а прямо из ресурса (/helloname/Igor)
        // Важно, что String name ищет одноименный параметр в ресурсах, тоесть имена должны совпадать,
        // ибо могут быть /helloname/{id}/{name} и т.п




        return "<h2>Hello " + name + "!</h2>";
    }

    @GetMapping("/hi/{name}")
    public ResponseEntity<String> hi(@PathVariable String name){
        // ResponseEntity<String> - параметризованный класс, отписывающий ответ. Параметризуется типом ответа(String)
        // Суть какбы в том, что так возвращается не ТЕЛО ОТВЕТА, а сам ОТВЕТ. Не чувствительный на @ResponseBody, чувствительный к установке параметров

        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body("<h2>Hello " + name + "!</h2>");
    }



}
