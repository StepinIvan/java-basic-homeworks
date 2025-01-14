package ru.otus.java.basic.homeworks.homework_13.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket socket = new ServerSocket(5000);
        System.out.println("Server run.");
        while (true) {
            String result;
            Socket client = socket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.printf("Подключился клиент с портом %d", client.getPort());
            System.out.println();

            String[] userInput = (String[]) inputStream.readObject();
            if (userInput[0].equals("exit")) {
                System.out.printf("Клиент с портом: %d отключился!", client.getPort());
                System.out.println();
                client.close();
                continue;
            }
            System.out.println(Arrays.toString(userInput));
            try {
                if (userInput.length > 3 || userInput.length < 2) throw new IOException("Неверный формат ввода");
            } catch (IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
                result = "Ошибка: " + e.getMessage();
                outputStream.writeUTF(result);
                outputStream.flush();
            }

            try {
                if (userInput.length == 3) {
                    result = result(userInput[0], userInput[1], userInput[2]);
                } else {
                    result = result(userInput[0], userInput[1]);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
                result = "Ошибка: " + e.getMessage();
                outputStream.writeUTF(result);
                outputStream.flush();
            }
            outputStream.writeUTF(result);
            outputStream.flush();
            System.out.println("Результате выполнения операции: \n" + result);
        }

    }


    public static String result(String firstValue, String secondValue, String mathematicalOperation) {
        switch (mathematicalOperation) {
            case "+":
                return String.valueOf(Double.parseDouble(firstValue) + Double.parseDouble(secondValue));
            case "-":
                return String.valueOf(Double.parseDouble(firstValue) - Double.parseDouble(secondValue));
            case "*":
                return String.valueOf(Double.parseDouble(firstValue) * Double.parseDouble(secondValue));
            case "/":
                if (Double.parseDouble(secondValue) != 0) {
                    return String.valueOf(Double.parseDouble(firstValue) / Double.parseDouble(secondValue));
                } else {
                    throw new IllegalArgumentException("Деление на 0");
                }
            case "%":
                return String.valueOf(Double.parseDouble(firstValue) % Double.parseDouble(secondValue));
            default:
                throw new IllegalArgumentException("Неверная операция. Используйте +, -, *, /, %, ln, lg, sqrt, " +
                        "sin, cos, tg, abs");
        }
    }

    public static String result(String firstValue, String mathematicalOperation) {
        switch (mathematicalOperation.toLowerCase()) {
            case "ln":
                if (Double.parseDouble(firstValue) > 0) {
                    return String.valueOf(Math.log(Double.parseDouble(firstValue)));
                } else {
                    throw new IllegalArgumentException("Логарифм определён только для положительных чисел");
                }
            case "lg":
                if (Double.parseDouble(firstValue) > 0) {
                    return String.valueOf(Math.log10(Double.parseDouble(firstValue)));
                } else {
                    throw new IllegalArgumentException("Логарифм определён только для положительных чисел");
                }
            case "sqrt":
                if (Double.parseDouble(firstValue) > 0) {
                    return String.valueOf(Math.sqrt(Double.parseDouble(firstValue)));
                } else {
                    throw new IllegalArgumentException("Квадратный корень определён только для положительных чисел");
                }
            case "sin":
                return String.valueOf(Math.sin(Double.parseDouble(firstValue)));
            case "cos":
                return String.valueOf(Math.cos(Double.parseDouble(firstValue)));
            case "tg":
                return String.valueOf(Math.tan(Double.parseDouble(firstValue)));
            case "abs":
                return String.valueOf(Math.abs(Double.parseDouble(firstValue)));
            default:
                throw new IllegalArgumentException("Неверная операция. Используйте +, -, *, /, %, ln, lg, sqrt, " +
                        "sin, cos, th, abs");
        }
    }
}
