package ru.gb.Bootcamp.Patterns.Visitor;

public class TextPersonVisitor extends PersonVisitor{
    @Override
    public void showInfoPerson(Student student) {
        String info = "Имя: "+ student.name + ", Фамилия: " + student.lastname + ", Группа: " + student.groupId + ".";
        System.out.println(info);
    }

    @Override
    public void showInfoPerson(Teacher teacher) {
        String info = "Имя: "+ teacher.name + ", Фамилия: " + teacher.lastname + ", Ведет групп: " + teacher.totalGroup + ".";
        System.out.println(info);
    }
}
