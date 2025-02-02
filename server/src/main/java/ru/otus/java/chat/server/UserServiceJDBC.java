package ru.otus.java.chat.server;

import java.util.List;

public interface UserServiceJDBC {
    List<User> getAll();

    boolean isAdmin(int userId);
}
