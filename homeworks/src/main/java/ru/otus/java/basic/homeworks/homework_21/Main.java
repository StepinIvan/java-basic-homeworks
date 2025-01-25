package ru.otus.java.basic.homeworks.homework_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Object monitor = new Object();
    private static int currentLetter = 0;

    public static void main(String[] args) {
        ExecutorService serv = Executors.newFixedThreadPool(3);
        serv.execute(() -> {
            printA();
        });
        serv.execute(() -> {
            printB();
        });
        serv.execute(() -> {
            printC();
        });
        serv.shutdown();
    }
    public static void printA() {
        for (int i = 0; i < 5; i++) {
            synchronized (monitor) {
                try {
                    while (currentLetter != 0) {
                        monitor.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("A");
                currentLetter = 1;
                monitor.notifyAll();
            }
        }
    }

    public static void printB() {
        for (int i = 0; i < 5; i++) {
            synchronized (monitor) {
                try {
                    while (currentLetter != 1) {
                        monitor.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("B");
                currentLetter = 2;
                monitor.notifyAll();
            }
        }
    }

    public static void printC() {
        for (int i = 0; i < 5; i++) {
            synchronized (monitor) {
                try {
                    while (currentLetter != 2) {
                        monitor.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("C");
                currentLetter = 0;
                monitor.notifyAll();
            }
        }
    }
}


