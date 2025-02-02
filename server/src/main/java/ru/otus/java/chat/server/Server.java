package ru.otus.java.chat.server;

import lombok.Getter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clientHandlerList;
    @Getter
    private AuthenticatedProvider authenticatedProvider;
    @Getter
    private List<User> usersList;
    @Getter
    private UserServiceJDBC userServiceJDBC;

    public Server(int port) throws SQLException {
        this.port = port;
        clientHandlerList = new CopyOnWriteArrayList<>();
        userServiceJDBC = new UserServiceJDBCImpl();
        usersList = userServiceJDBC.getAll();
        authenticatedProvider = new InMemoryAuthenticatedProvider(this);
    }

    public void start() {
        //
//        try {
            //userServiceJDBC = new UserServiceJDBCImpl();
            //usersList = userServiceJDBC.getAll();
            //System.out.println("userServiceJDBC.getAll() = " + userServiceJDBC.getAll());
//            for (User user : users) {
//                System.out.println("Пользователь с id = " + user.getId()
//                        + " является администратором?\n"
//                        + userServiceJDBC.isAdmin(user.getId())
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            authenticatedProvider.initialize();
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this);
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clientHandlerList.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clientHandlerList.remove(clientHandler);
        broadcastMessage("Из чата вышел: " + clientHandler.getUserName());
    }

    public void broadcastMessage(String message) {
        for (ClientHandler c : clientHandlerList) {
            c.sendMessage(message);
        }
    }

    public void privateMessage(String message, String name) {
        for (ClientHandler c : clientHandlerList) {
            if (c.getUserName().equals(name)) {
                c.sendMessage(message);
            }
        }
    }

    public void sendServerInformation(String name) {
        for (ClientHandler c : clientHandlerList) {
            if (c.getUserName().equals(name)) {
                c.sendMessage("Добро пожаловать на сервер. " +
                        "Для отправки личного сообщения его необходимо написать в формате \"/w username message\"\n" +
                        "Для выхода с сервера напишите \"/exit\")");
            }
        }
    }

    public boolean isUserNameBusy(String userName) {
        for (ClientHandler clientHandler : clientHandlerList) {
            if (clientHandler.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void kickUser(String userName) {
        for (ClientHandler clientHandler : clientHandlerList) {
            if (clientHandler.getUserName().equals(userName)) {
                clientHandler.sendMessage("Вы были отключены администратором.");
                privateMessage("/exitok", userName);
                break;
            }
        }
    }
}
