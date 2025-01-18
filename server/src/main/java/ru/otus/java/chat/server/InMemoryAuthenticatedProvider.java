package ru.otus.java.chat.server;

import lombok.Getter;
import lombok.Setter;
import ru.otus.java.chat.server.utils.userRoles;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider{

    private class User {
        private String login;
        private String password;
        private String userName;
        @Setter
        @Getter
        private userRoles userRole;

        public User(String login, String password, String userName) {
            this.login = login;
            this.password = password;
            this.userName = userName;
            this.userRole = userRoles.USER;
        }
    }
    private List<User> users;
    private Server server;

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
        users = new CopyOnWriteArrayList<>();
        users.add(new User("1","2","123"));
        users.get(0).setUserRole(userRoles.ADMIN);
        users.add(new User("2","3","321"));
        users.add(new User("John","123","HydraulicEngineer"));
        users.get(0).setUserRole(userRoles.ADMIN);
        users.add(new User("Alex","321","Scientist"));
        users.add(new User("Jack","321","Mechanic"));

    }

    @Override
    public void initialize() {
        System.out.println("Инициализация InMemoryAuthenticatedProvider");
    }

    private String getUserNameByLoginAndPassword (String login, String password) {
        for (User user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user.userName;
            }
        }
        return null;
    }
    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUserName = getUserNameByLoginAndPassword(login,password);
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

    private boolean isLoginAlreadyExist (String login) {
        for (User user : users) {
            if(user.login.equals(login)) {
                return true;
            }
        }
        return false;
    }
    private boolean isUserNameAlreadyExist (String userName) {
        for (User user : users) {
            if(user.userName.equals(userName)) {
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
        users.add(new User(login, password, userName));
        clientHandler.setUserName(userName);
        server.subscribe(clientHandler);
        clientHandler.sendMessage("/regok " + userName);
        return true;
    }
}
