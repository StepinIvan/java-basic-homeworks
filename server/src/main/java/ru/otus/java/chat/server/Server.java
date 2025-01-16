package ru.otus.java.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clientHandlerList;

    public Server(int port) {
        this.port = port;
        clientHandlerList = new CopyOnWriteArrayList<>();
    }

    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                subscribe(new ClientHandler(socket, this));
                this.privateMessage("Добро пожаловать на сервер. " +
                        "Для отправки личного сообщения его необходимо написать в формате \"/w username message\"\n" +
                        "Для выхода с сервера напишите \"/exit\"",
                        clientHandlerList.get(clientHandlerList.size() - 1).toString());
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe (ClientHandler clientHandler) {
        clientHandlerList.add(clientHandler);
    }
    public void unsubscribe (ClientHandler clientHandler) {
        clientHandlerList.remove(clientHandler);
        broadcastMessage("Из чата вышел: " + clientHandler.getUserName());
    }
    public void broadcastMessage(String message) {
        for (ClientHandler c: clientHandlerList) {
            c.sendMessage(message);
        }
    }
    public void privateMessage(String message, String name) {
        for (ClientHandler c: clientHandlerList) {
            if (c.getUserName().equals(name)) {
                c.sendMessage(message);
            }
        }
    }
}
