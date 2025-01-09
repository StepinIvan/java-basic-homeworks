package ru.otus.java.basic.homeworks.homework_13.client;

import ru.otus.java.basic.homeworks.homework_13.utils.ClientSample;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы подключились к серверу, для завершения сессия необходимо ввести команду exit");
        System.out.println("Вам доступны следующие математические операции: +, -, *, /, %, ln, lg, sqrt, sin, " +
                "cos, th, abs");
        System.out.println("Для использования +, -, *, /, % требуется вводить запрос в формате: число, число, " +
                "операция (2, 2, +) ");
        System.out.println("Для использования ln, lg, sqrt, sin, cos, th, abs требуется вводить запрос в формате: " +
                "число, операция (2, +) ");
        while (true) {
            try (Socket socket = new Socket("localhost", 5000)) {
                ClientSample client = new ClientSample(socket.getInputStream(), socket.getOutputStream());

                System.out.println("Введите запрос:");
                String userMessage = scanner.nextLine();
                if (userMessage.equals("exit")) {
                    client.send(userMessage);
                    break;
                }
                client.send(userMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
