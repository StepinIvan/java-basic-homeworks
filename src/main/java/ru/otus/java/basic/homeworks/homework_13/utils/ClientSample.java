package ru.otus.java.basic.homeworks.homework_13.utils;

import java.io.*;

public class ClientSample implements AutoCloseable {
    private final DataInputStream inputStream;
    private final ObjectOutputStream outputStream;

    public ClientSample(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.inputStream = new DataInputStream(inputStream);
        ;
        this.outputStream = new ObjectOutputStream(outputStream);
    }

    public void send(String message) throws IOException {
        String[] splittedUserMessage = message.replaceAll("\\s", "").split(",");
        outputStream.writeObject(splittedUserMessage);
        outputStream.flush();
        try {
//            if (splittedUserMessage[2].equals("%")) {
//                Integer result = inputStream.readInt();
//                System.out.printf(String.format("%s %s %s = %d", splittedUserMessage[0], splittedUserMessage[2],
//                        splittedUserMessage[1],result));
//            } else {
            String result = inputStream.readUTF();
            System.out.println("Результате выполнения операции: \n"+ result);
        } catch (EOFException e) {
            System.out.println("Сервер закрыл соединение.");
        }
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
