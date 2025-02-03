package ru.otus.java.basic.homeworks.homework_23;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpServer {
    private int port;
    private Dispatcher dispatcher;
    private ExecutorService threadPool;
    private int numberOfThreads = 10;
    private static final Logger LOGGER = LogManager.getLogger(HttpServer.class);


    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
        this.threadPool = Executors.newFixedThreadPool(numberOfThreads);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            LOGGER.info("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                LOGGER.info("Подключился новый клиент");
                threadPool.execute(() -> {
                    try(socket) {
                        byte[] buffer = new byte[8192];
                        int n = socket.getInputStream().read(buffer);
                        if (n < 0) {
                            return;
                        }
                        HttpRequest request = new HttpRequest(new String(buffer, 0, n));
                        request.info();
                        dispatcher.execute(request, socket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
