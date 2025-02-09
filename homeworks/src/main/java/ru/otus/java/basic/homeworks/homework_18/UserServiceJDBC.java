package ru.otus.java.basic.homeworks.homework_18;

import java.util.List;

public interface UserServiceJDBC {
    List<User> getAll();

    boolean isAdmin(int userId);
}
