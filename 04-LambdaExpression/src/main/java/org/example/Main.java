package org.example;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
        });
        Thread thread1 = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        thread1.start();
    }
}