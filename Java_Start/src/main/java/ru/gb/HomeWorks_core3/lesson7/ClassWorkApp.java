package ru.gb.HomeWorks_core3.lesson7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassWorkApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
//        reflection();

        CatAnnotation catAnnotation = new CatAnnotation("Vanja", "Grey", 8, 4);
        Class<CatAnnotation> catAnnotationClass = CatAnnotation.class;

        for (Method method :
                catAnnotationClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnotation.class)) {
                if (method.getAnnotation(MyAnotation.class).priority() > 5) {
                    method.invoke(catAnnotation);
                    System.out.println(method.getAnnotation(MyAnotation.class).priority());
                }
                if (method.getAnnotation(MyAnotation.class).count() > 1) {
                    method.invoke(catAnnotation);
                    System.out.println(method.getAnnotation(MyAnotation.class).count());
                }

            }
        }
    }

    private static void reflection() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Cat cat = new Cat("Barsik");
        Class<Cat> catClass1 = (Class<Cat>) cat.getClass();
        Class<Cat> catClass2 = Cat.class;
        Class<?> catClass3 = Class.forName("ru.gb.HomeWorks_core3.lesson7.Cat"); //Если нет воможности получить обьект класса

        System.out.println(catClass2.getName());
        System.out.println(catClass3.getSimpleName());

        int modifiers = catClass2.getModifiers();
        System.out.println(Modifier.isPublic(modifiers));
        System.out.println(Modifier.isInterface(modifiers));
        System.out.println(catClass2.getSuperclass());
        System.out.println(Arrays.toString(catClass2.getInterfaces()));

        Method[] methods = catClass2.getMethods();
        System.out.println(Arrays.toString(methods));
        Method[] declaredMethods = catClass2.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));
        Method method = catClass2.getMethod("info");
        Method method2 = catClass2.getMethod("info", String.class);

        Field[] fields = catClass2.getFields();
        System.out.println(Arrays.toString(fields));
        Field[] fieldsAll = catClass2.getDeclaredFields();
        System.out.println(Arrays.toString(fieldsAll));

        System.out.println(cat.info());
        Field name = catClass2.getDeclaredField("name");
        System.out.println(name);
        name.setAccessible(true);
        name.set(cat, "Murzik");
        name.setAccessible(false);
        System.out.println(cat.info());

        Dog dog = new Dog();
        dog.setName("Chirsse");
        Dog dog2 = new Dog("Sharick");
    }
}
