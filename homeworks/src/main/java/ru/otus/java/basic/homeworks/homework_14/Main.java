package ru.otus.java.basic.homeworks.homework_14;

public class Main {
    public static void main(String[] args) {
        fillingArray(100_000_000);
        fillingArrayWithThreads(100_000_000, 4);
    }
    public static void fillingArray(int arraySize) {
        double[] array = new double[arraySize];
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i/1.2);
        }
        long endTime = System.nanoTime();
        long arrayFillingTime = endTime - startTime;
        double arrayFillingTimeInSeconds = arrayFillingTime / 1e9;
        System.out.println("Время заполнения массива без использования многопоточности: " + arrayFillingTimeInSeconds);
    }
    public static void fillingArrayWithThreads(int arraySize, int threadNumbers) {
        double[] array = new double[arraySize];
        Thread[] threads = new Thread[threadNumbers];
        long startTime = System.nanoTime();
        for (int i = 0; i < threadNumbers; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                int startArrayIndex = (arraySize/threadNumbers) * threadIndex;
                int endArrayIndex = (arraySize/threadNumbers) * (threadIndex + 1);
                for (int j = startArrayIndex; j < endArrayIndex; j++) {
                    array[j] = 1.14 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j/1.2);
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        long arrayFillingTime = endTime - startTime;
        double arrayFillingTimeInSeconds = arrayFillingTime / 1e9;
        System.out.println("Время заполнения массива в 4х параллельных потоках: " + arrayFillingTimeInSeconds);
    }
}