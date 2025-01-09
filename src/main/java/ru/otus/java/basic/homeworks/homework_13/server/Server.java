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
            if (userInput.length > 3 || userInput.length < 2) throw new IOException("Неверный формат ввода");
            double result = 0;
            try {
                if (userInput.length == 3) {
                    result = result(userInput[0], userInput[1], userInput[2]);
                } else {
                        result = result(userInput[0], userInput[1]);
                }
            }catch(IllegalArgumentException e){
                    System.out.printf(String.format("Ошибка: %s", e.getMessage()));
                    System.out.println();
                    break;
                }
                outputStream.writeDouble(result);
                outputStream.flush();
                System.out.printf(String.format("%s %s %s = %f ", userInput[0], userInput[2], userInput[1], result));
                System.out.println();
            }

    }


    public static double result(String firstValue, String secondValue, String mathematicalOperation) {
        switch (mathematicalOperation) {
            case "+":
                return Double.parseDouble(firstValue) + Double.parseDouble(secondValue);
            case "-":
                return Double.parseDouble(firstValue) - Double.parseDouble(secondValue);
            case "*":
                return Double.parseDouble(firstValue) * Double.parseDouble(secondValue);
            case "/":
                if (Double.parseDouble(secondValue) != 0) {
                    return Double.parseDouble(firstValue) / Double.parseDouble(secondValue);
                } else {
                    throw new IllegalArgumentException("Деление на 0");
                }
            case "%":
                    return Double.parseDouble(firstValue) % Double.parseDouble(secondValue);
            default:
                throw new IllegalArgumentException("Неверная операция. Используйте +, -, *, /, %, ln, lg, sqrt, " +
                        "sin, cos, th, abs");
        }
    }
    public static double result(String firstValue, String mathematicalOperation) {
        switch (mathematicalOperation) {
            case "ln":
                if (Double.parseDouble(firstValue) < 0) {
                    return Math.log(Double.parseDouble(firstValue));
                } else {
                    throw new IllegalArgumentException("Логарифм определён только для положительных чисел");
                }
            case "lg":
                if (Double.parseDouble(firstValue) < 0) {
                    return Math.log10(Double.parseDouble(firstValue));
                } else {
                    throw new IllegalArgumentException("Логарифм определён только для положительных чисел");
                }
            case "sqrt":
                if (Double.parseDouble(firstValue) < 0) {
                    return Math.sqrt(Double.parseDouble(firstValue));
                } else {
                    throw new IllegalArgumentException("Квадратный корень определён только для положительных чисел");
                }
            case "sin":
                return Math.sin(Double.parseDouble(firstValue));
            case "cos":
                return Math.cos(Double.parseDouble(firstValue));
            case "tg":
                return Math.tan(Double.parseDouble(firstValue));
            case "abs":
                return Math.abs(Double.parseDouble(firstValue));
            default:
                throw new IllegalArgumentException("Неверная операция. Используйте +, -, *, /, %, ln, lg, sqrt, " +
                        "sin, cos, th, abs");
        }
    }
}
