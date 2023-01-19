package ru.gb.Hibernate_ClassWork.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity                                                     // делает класс сущностью базы данных
@Table(name = "users")                                      // указывает название таблицы в БД
@NamedQueries({                                             // Это способ сохранить шаблоны запросов, а потом вызывать их по названию
        @NamedQuery(name = "userByName", query = "from Student u where u.name=:name"),
        @NamedQuery(name = "allStudents", query = "from Student")
})
public class Student {

    @Id                                                     // указывает что это поле Первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // указывает на Автогенерацию значений, IDENTITY - означает, что за генерацию отвечает База данных
    private Long id;
    @Column                                                 // @Column - не обязательная аннотация, но если надо сделать, чтобы какие-то поля сохранялись в бвзу, а какието нет -
//    @Transient                                            // надо поставить @Transient чтобы поле НЕ сохранялось и @Column, чтобы сохранялось
    private Integer score;
    @Column(length = 128, unique = true, nullable = false)  // @Column - также позволяет задавать настройки колонок, в данном случает Ненулевое, уникальное, длинна 128 символов
    private String name;


//    @Timestamp                                             // Еще 3 полезные аннотации для работы с полями времени
//    @CreationTimestamp
//    @UpdateTimestamp

    public Student() {                                      // У класса сущности БД в обязательном порядке должен быть конструктор по умолчанию и все геттеры и сеттеры
    }

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
