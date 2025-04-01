package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calculation calculation = new Calculation();
        Thread t1 = new Thread(() ->{
            for(int i=0; i<1000; i++){
                calculation.increment();
            }
        });

        Thread t2 = new Thread(() ->{
            for(int i=0; i<1000; i++){
                calculation.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Value: " + calculation.num);
    }
}

class Calculation {
    int num;
    public synchronized void increment() {
        num++;
    }
}