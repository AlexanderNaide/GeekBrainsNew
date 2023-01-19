package ru.gb.Bootcamp.Patterns.Visitor;

public class XmlPersonVisitor extends PersonVisitor{
    @Override
    public void showInfoPerson(Student student) {
        String info = "<Root><Name>" + student.name + "</Name><Lastname>" + student.lastname + "</Lastname><GroupId>" + student.groupId + "</GroupID></Root>";
        System.out.println(info);
    }

    @Override
    public void showInfoPerson(Teacher teacher) {
        String info = "<Root><Name>" + teacher.name + "</Name><Lastname>" + teacher.lastname + "</Lastname><TotalGroup>" + teacher.totalGroup + "</TotalGroup></Root>";
        System.out.println(info);
    }
}
