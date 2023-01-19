package ru.gb.spring_mvc.HomeWork_MVC;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Вот эта дрянь не дает забирать статические файлы из папки static

@Configuration
@EnableWebMvc
public class Over implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry
                .addResourceHandler("/styles/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
}
