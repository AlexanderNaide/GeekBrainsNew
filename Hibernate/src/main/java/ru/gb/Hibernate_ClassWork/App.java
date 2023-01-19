package ru.gb.Hibernate_ClassWork;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import ru.gb.Hibernate_ClassWork.model.Student;

import java.util.List;

public class App {


    // В принципе SessionFactory и EntityManagerFactory выполняют одну и ту же функцию и многие считают, что это одно и то же, но:
    // 1 - EntityManagerFactory родился когда Hibernate подгоняли под стандарт JPA, значит он новее и правильнее.
    // 2 - Из всех ТОЛЬКО EntityManagerFactory является потокобезопасным!!! ВАЖНО!

//    private static SessionFactory sessionFactory;
    private static EntityManagerFactory  entityFactory;

    public static void init(){
        entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown(){
        if(entityFactory != null){
            entityFactory.close();
        }
    }

    public static void main(String[] args) {

        try{
            init();
            EntityManager em = entityFactory.createEntityManager();


            // INSERT
/*            em.getTransaction().begin();
            Student student = new Student("Max", 65);
            em.persist(student);
            em.getTransaction().commit();
            em.close();*/


            // SELECT
/*            Student stAr = em.find(Student.class, 1L);
            System.out.println(stAr.getName() + " " + stAr.getScore());*/


            // SELECT *
/*            List<Student> list = em.createQuery("from Student", Student.class)
                    .getResultList();
            list.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));*/


            // SELECT (WHERE) - язык HQL или JPQL
/*            Student student = (Student) em.createQuery("from Student s where s.name = :name")
                    .setParameter("name", "Tim")
                    .getSingleResult();
            System.out.println(student.getId() + " " + student.getName() + " " + student.getScore());*/


            // Hibernate может осуществлять запросы в базу в чистом коде
/*            Student student = (Student) em.createNativeQuery("select * from users where name = 'Bob'", Student.class)
                    .getSingleResult();
            System.out.println(student.getId() + " " + student.getName() + " " + student.getScore());*/


            // Вызов сохраненных запросов (в классе)
/*            Student student = (Student) em.createNamedQuery("userByName")
                    .setParameter("name", "Tim")
                    .getSingleResult();
            System.out.println(student.getId() + " " + student.getName() + " " + student.getScore());*/


            // UPDATE
/*            Student student = em.find(Student.class, 1L);
            em.getTransaction().begin();
            student.setScore(110);
            em.getTransaction().commit();
            em.close();*/


            // DELETE
/*            em.getTransaction().begin();
            em.remove(em.find(Student.class, 4L));
            em.getTransaction().commit();
            em.close();*/

            // или (более правильно)
/*            Student student = em.find(Student.class, 5L);
            if (student != null){
                em.getTransaction().begin();
                em.remove(student);
                em.getTransaction().commit();
                em.close();
            }*/

            // или при помощи HQL
            em.getTransaction().begin();
            em.createQuery("delete from Student s where s.name = :name")
                    .setParameter("name", "Max")
                    .executeUpdate();
            em.getTransaction().commit();
            em.close();



        } catch (Exception e){
            e.printStackTrace();
        } finally {
            shutdown();
        }

    }
}
