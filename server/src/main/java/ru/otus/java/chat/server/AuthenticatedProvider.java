package ru.otus.java.chat.server;

import ru.otus.java.chat.server.utils.userRoles;

public interface AuthenticatedProvider {
    void initialize();
    boolean authenticate(ClientHandler clientHandler, String login,
                         String password);
    boolean registration(ClientHandler clientHandler, String login,
                         String password, String userName);
    userRoles getUserRole(String userName);
}
