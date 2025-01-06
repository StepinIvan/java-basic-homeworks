package ru.otus.java.basic.homeworks.homework_12;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        workWithFile();
    }

    public static void takeListOfTextFiles() {
        File file = new File(".");
        FileFilter filter = new FileFilter() {
            public boolean accept(File f) {
                return f.getName().endsWith(".txt");
            }
        };
        System.out.printf(String.format("Файлы в директории:\n %s", Arrays.toString(file.listFiles(filter))));
        System.out.println();
    }

    public static void readFile(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(fileName);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             InputStreamReader reader = new InputStreamReader(bufferedInputStream)) {
            int symbol = reader.read();
            while (symbol != -1) {
                System.out.print((char) symbol);
                symbol = reader.read();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName, String sentence) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
            byte[] buffer = sentence.getBytes(StandardCharsets.UTF_8);
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void workWithFile() {
        takeListOfTextFiles();
        System.out.println("Введите название файла с которым хотите продолжить работу: ");
        Scanner scanner_1 = new Scanner(System.in);
        String fileName = scanner_1.next();
        System.out.println("Содержимое выбранного файла: ");
        readFile(fileName);
        System.out.println("Введите строку, которую вы хотели бы добавить в текущий файл: ");
        Scanner scanner_2 = new Scanner(System.in);
        String sentence = scanner_2.nextLine();
        writeToFile(fileName, sentence);
        System.out.println("Содержимое файла после добавления: ");
        readFile(fileName);

        System.out.println("Хотите продолжить работу с файлами? (Ответить необходимо Да/Нет)");
        scanAnswer();
    }

    public static void scanAnswer() {
        Scanner answerScanner = new Scanner(System.in);
        String answer = answerScanner.nextLine();
        if (answer.equals("Да")) {
            workWithFile();
        } else if (answer.equals("Нет")) {
            System.exit(0);
        } else {
            System.out.println("Ответ не соответствует формату Да/Нет, попробуйте снова");
            scanAnswer();
        }
    }
}
