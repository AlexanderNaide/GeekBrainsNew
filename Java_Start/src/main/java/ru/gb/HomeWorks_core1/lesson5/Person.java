package ru.gb.HomeWorks_core1.lesson5;

public class Person {

    private static final Person[] personArray = new Person[5];

    private String name;
    private String post;
    private String mail;
    private String phone;
    private int wages;
    private int age;

    public Person(String name, String post, String mail, String phone, int wages, int age){
        this.name = name;
        this.post = post;
        this.mail = mail;
        this.phone = phone;
        this.wages = wages;
        this.age = age;
    }

    public void printPerson(){
//        System.out.printf("Name: %s\nPost: %s\nPhone number: %s\nEmail: %s\nAge: %d\nWages: %d\n\n", name, post, phone, mail, age, wages);
        System.out.printf("""
                        Name: %s
                        Post: %s
                Phone number: %s
                       Email: %s
                         Age: %d
                       Wages: %d
        
                """, name, post, phone, mail, age, wages);
    }

    public static void main(String[] args) {
        personArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 40);
        personArray[1] = new Person("Petrov Petr", "Engineer", "petrov@mailbox.com", "89142745523", 30000, 36);
        personArray[2] = new Person("Dorodnikh Mikhail", "Manager", "dorodnikh@mailbox.com", "89193221612", 28000, 42);
        personArray[3] = new Person("Savankulova Oksana ", "Accountant", "savankulova@mailbox.com", "89191777315", 50000, 27);
        personArray[4] = new Person("Karamulka Ismail", "Director", "director@mailbox.com", "89207778888", 100000, 54);

        for (Person p : personArray){
            if (p.age >= 40){
                p.printPerson();
            }
        }

    }
}
