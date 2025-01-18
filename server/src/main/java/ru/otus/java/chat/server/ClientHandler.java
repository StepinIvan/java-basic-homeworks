package ru.otus.java.chat.server;

import lombok.Getter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    @Getter
    private String userName;
    private static int userCount = 0;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.inputStream = new DataInputStream((socket.getInputStream()));
        this.outputStream = new DataOutputStream(socket.getOutputStream());

        userCount++;
        userName = "user" + userCount;

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился, порт: " + socket.getPort());
                while (true) {
                    String message = inputStream.readUTF();
                    String[] splittedMessage = message.split(" ", 3);
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }
                        if (splittedMessage[0].equalsIgnoreCase("/w")) {
                            server.privateMessage("(Private message) " + userName + ": "
                                    + splittedMessage[2], splittedMessage[1]);
                        }
                    } else {
                        server.broadcastMessage(userName + ": " + message);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    @Override
    public String toString() {
        return userName;
    }

    public void sendMessage(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
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
}
