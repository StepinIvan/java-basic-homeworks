package ru.otus.java.chat.server;

import lombok.Getter;
import lombok.Setter;
import ru.otus.java.chat.server.utils.userRoles;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    @Getter
    private String login;
    @Getter
    private String password;
    @Getter
    private String userName;
    @Getter
    private List<Role> roles = new ArrayList<>();
//    @Setter
//    @Getter
//    private Role userRole;

    public User(int id, String login, String password, String userName) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userName = userName;
        //this.userRole = Role.USER;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

}
