package ru.otus.java.basic.homeworks.homework_20;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        File file = new File(".");
        FileFilter filter = new FileFilter() {
            public boolean accept(File f) {
                return f.getName().endsWith(".txt");
            }
        };
        System.out.printf(String.format("Файлы в директории:\n %s", Arrays.toString(file.listFiles(filter))));
        System.out.println();

        System.out.println("Введите название файла в котором необходимо подсчитать количество последовательностей: ");
        Scanner fileNameScanner = new Scanner(System.in);
        String fileName = fileNameScanner.next().trim();
        System.out.println("Введите искомую последовательность: ");
        Scanner searchStringScanner = new Scanner(System.in);
        String searchString = searchStringScanner.next();
        System.out.println("В выбранном файле количество последовательностей равно: "
                + countStringOccurrence(fileName, searchString));
    }

    public static int countStringOccurrence(String fileName, String searchString) {
        int count = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int index = 0;
                while ((index = line.indexOf(searchString, index)) != -1) {
                    count++;
                    index += searchString.length();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
