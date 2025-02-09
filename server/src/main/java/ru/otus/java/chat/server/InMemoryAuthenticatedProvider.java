package ru.otus.java.chat.server;

import lombok.Getter;
import lombok.Setter;
import ru.otus.java.chat.server.utils.userRoles;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider {

    private List<User> users;
    private Server server;

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
        users = server.getUsersList();
    }

    @Override
    public void initialize() {
        System.out.println("Инициализация InMemoryAuthenticatedProvider");
    }

    private String getUserNameByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user.getUserName();
            }
        }
        return null;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUserName = getUserNameByLoginAndPassword(login, password);
        if (authUserName == null) {
            clientHandler.sendMessage("Неверный логин/пароль");
            return false;
        }
        if (server.isUserNameBusy((authUserName))) {
            clientHandler.sendMessage("Указанная учетная " +
                    "запись уже занята");
            return false;
        }
        clientHandler.setUserName(authUserName);
        server.subscribe(clientHandler);
        clientHandler.sendMessage("/authok " + authUserName);
        return true;
    }

    private boolean isLoginAlreadyExist(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUserNameAlreadyExist(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String userName) {
        if (login.length() < 3 || password.length() < 3 || userName.length() < 3) {
            clientHandler.sendMessage("Несоблюдены условия регистрации. Логин, пароль и никнейм должен быть от 3х символов");
            return false;
        }
        if (isLoginAlreadyExist(login)) {
            clientHandler.sendMessage("Указанный логин уже занят");
            return false;
        }
        if (isUserNameAlreadyExist(userName)) {
            clientHandler.sendMessage("Указанный никнейм занят");
            return false;
        }
        users.add(new User(users.size() + 1,login, password, userName));
        clientHandler.setUserName(userName);
        server.subscribe(clientHandler);
        clientHandler.sendMessage("/regok " + userName);
        return true;
    }

    @Override
    public boolean isAdmin(String userName) {
        User user = null;
        for (User us : users) {
            if (us.getUserName().equals(userName)) {
                user = us;
            }
        }
        return server.getUserServiceJDBC().isAdmin(user.getId());
    }

}
