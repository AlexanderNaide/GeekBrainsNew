package ru.gb.HomeWorks_core3.lesson4;

public class ClassWorkApp {
    public static void main(String[] args) throws InterruptedException {
//        baseMethod();

//        isAliveMethod();

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestS.mstatic1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestS.mstatic2();
            }
        }).start();


    }

    private static void isAliveMethod() {
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(i);
                }
            }
        });
        t3.start();

        while(true) {
            if (!t3.isAlive()){
                break;
            }
        }

        System.out.println("end");
    }

    private static void baseMethod() throws InterruptedException {
        MyThreadClass t1 = new MyThreadClass();
        t1.start();
        MyRunnableClass myRunnableClass = new MyRunnableClass();
        Thread t2 = new Thread(myRunnableClass);
        t2.start();

        t1.join();
        t2.join();

        System.out.println("end");
    }
}


class TestS {
    public synchronized static void mstatic1(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized static void mstatic2(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThreadClass extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}

class MyRunnableClass implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}