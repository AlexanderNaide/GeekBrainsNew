package ru.gb.SpringContext.ClassWork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Configuration
@ComponentScan("ru.gb.SpringContext.ClassWork")
public class AppConfig {

    // пример создания бина из библиотечного класса внутри @Configuration
    @Bean
    public FileOutputStream fileOut() throws FileNotFoundException {
        return new FileOutputStream("1.txt");
    }
}
