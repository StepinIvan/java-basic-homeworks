package ru.otus.java.chat.server;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider{

    private class User {
        private String login;
        private String password;
        private String userName;
    }
    @Override
    public void initialize() {
        System.out.println("Инициализация InMemoryAuthenticatedProvider");
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        return false;
    }
}
