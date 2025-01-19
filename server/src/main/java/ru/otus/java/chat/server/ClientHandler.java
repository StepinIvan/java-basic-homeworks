package ru.otus.java.chat.server;

import lombok.Getter;
import lombok.Setter;
import ru.otus.java.chat.server.utils.userRoles;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    @Getter
    @Setter
    private String userName;
    @Setter
    private boolean inFlag;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.inputStream = new DataInputStream((socket.getInputStream()));
        this.outputStream = new DataOutputStream(socket.getOutputStream());
        this.inFlag = true;

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился, порт: " + socket.getPort());
                while (true) {
                    sendMessage("Для начала работы необходимо пройти аутентификацию. Формат команды: " +
                            "/auth login password\n" +
                            "или зарегистрироваться. Формат команды: /reg login password username");
                    String message = inputStream.readUTF();
                    if (message.equalsIgnoreCase("/exit")) {
                        sendMessage("/exitok");
                        inFlag = false;
                        break;
                    }
                    if (message.startsWith("/auth ")) {
                        String[] splittedAuthorization = message.split(" ");
                        if (splittedAuthorization.length != 3) {
                            sendMessage("Неверный формат команды");
                            continue;
                        }
                        if (server.getAuthenticatedProvider().authenticate(this, splittedAuthorization[1],
                                splittedAuthorization[2])) {
                            server.sendServerInformation(this.userName);
                            break;
                        }
                    }
                    if (message.startsWith("/reg ")) {
                        String[] splittedAuthorization = message.split(" ");
                        if (splittedAuthorization.length != 4) {
                            sendMessage("Неверный формат команды");
                            continue;
                        }
                        if (server.getAuthenticatedProvider().registration(this,
                                splittedAuthorization[1], splittedAuthorization[2], splittedAuthorization[3])) {
                            break;
                        }
                    }
                }
                while (inFlag) {
                    String message = inputStream.readUTF();
                    if (message.startsWith("/")) {
                        String[] splittedMessage = message.split(" ", 3);
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }
                        if (splittedMessage[0].equalsIgnoreCase("/w")) {
                            server.privateMessage("(Private message) " + userName + ": "
                                    + splittedMessage[2], splittedMessage[1]);
                        }
                    } else {
                        server.broadcastMessage(userName + ": " + message);
                    }
                    if (message.startsWith("/kick ")) {
                        String[] splittedMessage = message.split(" ");
                        if (splittedMessage.length != 2) {
                            sendMessage("Неверный формат команды. Используйте: /kick username");
                            continue;
                        }
                        if (server.getAuthenticatedProvider().getUserRole(userName) == userRoles.ADMIN) {
                            String userNameToKick = splittedMessage[1];
                            server.kickUser(userNameToKick);
                        } else {
                            sendMessage("У вас нет прав для выполнения этой команды.");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    @Override
    public String toString() {
        return userName;
    }

    public void sendMessage(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeFlag() {
        inFlag = false;
    }
}
