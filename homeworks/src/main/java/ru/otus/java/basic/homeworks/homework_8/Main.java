package ru.otus.java.basic.homeworks.homework_8;

public class Main {
    public static void main(String[] args) {
        String[][] array = {{"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}};
        String[][] faultArray_1 = {{"1","2","3"},
                {"5","6","7"},
                {"9","10","11"},
                {"13","14","15"}};
        String[][] faultArray_2 = {{"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12т"},
                {"13","14","15","16"}};
        try {
            System.out.println(sumArray(array));
        } catch (AppArraySizeException | AppArrayDataException e) {
            e.printStackTrace();
        }

    }
    public static int sumArray (String[][] array) {
        int sum = 0;
        if (array.length != 4 || array[0].length != 4) throw new AppArraySizeException("Размерность массива должна быть 4х4");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(String.format("Неверная запись числа в строке %d и столбце %d (нумерация строк и столбцов с 0)", i, j));
                }
            }
        }
        return sum;
    }
}
