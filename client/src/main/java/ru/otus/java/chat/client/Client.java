package ru.otus.java.chat.client;

import lombok.Getter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private Scanner scanner;
    private boolean flag = true;

    public Client() throws IOException {
        scanner = new Scanner(System.in);
        socket = new Socket("localhost", 8189);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
        new Thread(() -> {
            try {
                while (true) {
                    String message = inputStream.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exitok")) {
                            break;
                        }
                        if (message.startsWith("/authok ")) {
                            System.out.println("Успешная аутентификация. Вы присоединилсь к чату. Ваше имя пользователя: " +
                                    message.split(" ")[1]);
                        }
                        if (message.startsWith("/regok ")) {
                            System.out.println("Успешная регистрация пользователя с никнеймом: " +
                                    message.split(" ")[1]);
                        }
                    } else {
                        System.out.println(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();

        while (flag) {
            String message = scanner.nextLine();
            outputStream.writeUTF(message);
            if (message.equalsIgnoreCase("/exit")) {
                break;
            }
        }

    }


    public void disconnect() {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeFlag() {
        flag = false;
    }
}
