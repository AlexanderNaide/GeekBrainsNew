package ru.gb.HomeWorks_core3.lesson7.HomeWork;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RunTests<T> {
    private Class<T> myTestClass;
    private T myTest;
    private Method[] methods;
    private Method beforeSuiteMethod;
    private Method afterSuiteMethod;
    private NavigableMap<Integer, Method> list;

    public static <T> void start(Class<T> clazz) {
        try {
            RunTests<T> runTests = new RunTests<T>();
            runTests.myTestClass = clazz;
            runTests.initialise();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static <T> void start(String className) {
        try {
            RunTests<T> runTests = new RunTests<>();
            runTests.myTestClass = (Class<T>) Class.forName("ru.gb.HomeWorks_core3.lesson7.HomeWork." + className);
            runTests.initialise();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initialise() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        myTest = myTestClass.getDeclaredConstructor().newInstance();
        methods = myTestClass.getDeclaredMethods();
        beforeSuiteMethod = null;
        afterSuiteMethod = null;
        list = new TreeMap<>();
        test();
    }

    private void test() throws InvocationTargetException, IllegalAccessException {

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuiteMethod == null) {
                    beforeSuiteMethod = method;
                } else {
                    throw new RuntimeException();
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuiteMethod == null) {
                    afterSuiteMethod = method;
                } else {
                    throw new RuntimeException();
                }
            }
            if (method.isAnnotationPresent(TestAnnotation.class)) {
                list.put(method.getAnnotation(TestAnnotation.class).priority(), method);
            }
        }
        beforeSuiteMethod.invoke(myTest);
        for (Method method : list.descendingMap().values()) {
            method.invoke(myTest);
        }
        afterSuiteMethod.invoke(myTest);
    }

}
