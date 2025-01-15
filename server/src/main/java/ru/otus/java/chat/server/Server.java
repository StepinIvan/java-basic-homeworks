package ru.otus.java.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
}
