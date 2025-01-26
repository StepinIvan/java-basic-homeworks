package ru.otus.java.basic.homeworks.homework_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Object monitor = new Object();
    private static int currentLetter = 0;

    public static void main(String[] args) {
        ExecutorService serv = Executors.newFixedThreadPool(3);
        serv.execute(() -> {
            printLetter('A');
        });
        serv.execute(() -> {
            printLetter('B');
        });
        serv.execute(() -> {
            printLetter('C');
        });
        serv.shutdown();
        try {
            if (!serv.awaitTermination(1, TimeUnit.SECONDS)) {
                serv.shutdownNow();
            }
        } catch (InterruptedException e) {
            serv.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    public static void printLetter(char letter) {
        for (int i = 0; i < 5; i++) {
            synchronized (monitor) {
                if (letter == 'A') {
                    try {
                        while (currentLetter != 0) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread was interrupted: " + e.getMessage());
                    }
                    System.out.print(letter);
                    currentLetter = 1;
                    monitor.notifyAll();
                } else if (letter == 'B') {
                    try {
                        while (currentLetter != 1) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread was interrupted: " + e.getMessage());
                    }
                    System.out.print(letter);
                    currentLetter = 2;
                    monitor.notifyAll();
                } else {
                    try {
                        while (currentLetter != 2) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread was interrupted: " + e.getMessage());
                    }
                    System.out.print(letter);
                    currentLetter = 0;
                    monitor.notifyAll();
                }
            }
        }
    }
}


