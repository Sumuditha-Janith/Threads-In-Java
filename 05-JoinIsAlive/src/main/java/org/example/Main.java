package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
        });
        t1.start();
//        System.out.println("T1 Alive: " + t1.isAlive());
        System.out.println("T2 Alive: " + t2.isAlive());
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        t2.start();
//        System.out.println("T1 Alive: " + t1.isAlive());
        System.out.println("T2 Alive: " + t2.isAlive());

        t1.join();
//        System.out.println("T1 Alive: " + t1.isAlive());
        System.out.println("T2 Alive: " + t2.isAlive());
        t2.join();
//        System.out.println("T1 Alive: " + t1.isAlive());
        System.out.println("T2 Alive: " + t2.isAlive());

        System.out.println("Bye");
//        System.out.println("T1 Alive: " + t1.isAlive());
        System.out.println("T2 Alive: " + t2.isAlive());

    }
}