package ru.otus.java.chat.server;

public interface AuthenticatedProvider {
    void initialize();
    boolean authenticate(ClientHandler clientHandler, String login,
                         String password);
}
