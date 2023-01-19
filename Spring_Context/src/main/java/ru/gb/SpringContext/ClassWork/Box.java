package ru.gb.SpringContext.ClassWork;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
//@Scope("singleton")
public class Box {
    private String color;

    @PostConstruct
    public void init(){
        this.color = "red";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
