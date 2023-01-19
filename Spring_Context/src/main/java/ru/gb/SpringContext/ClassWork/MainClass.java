package ru.gb.SpringContext.ClassWork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.gb.SpringContext.ClassWork");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

/*            Box box1 = context.getBean(Box.class);
            Box box2 = context.getBean(Box.class);

    //        box1.setColor("Red");
            box2.setColor("Green");

            System.out.println(box1.getColor());
            System.out.println(box2.getColor());*/

        OrderService orderService = context.getBean(OrderService.class);
        orderService.createOrderFromProduct(1L);
        orderService.createOrderFromProduct(1L);
        orderService.createOrderFromProduct(1L);
        orderService.createOrderFromProduct(1L);

        context.close();
    }
}
