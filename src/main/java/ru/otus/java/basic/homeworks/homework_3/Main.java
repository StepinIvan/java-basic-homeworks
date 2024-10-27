package ru.otus.java.basic.homeworks.homework_3;


public class Main {
    public static void main(String[] args) {
        int[][] array_1 = {{1, 2, 3}, {4, 5, -6}, {7, -8, 9}, {-10, 11, 12}};
        int[][] array_2 = {{1, 2, 3, 1, 2}, {4, 5, 6, 1, 2}, {7, 8, 9, 1, 2}, {7, 8, 9, 1, 2}, {7, 8, 9, 1, 2}};
        int[][] array_3 = new int[3][6];
        System.out.println("Сумма положительных элементов двумерного массива = " + simOfPositiveElements(array_1));
        printUserDimensionSquare(4);
        makeDiagonalElementsZero(array_2);
        for (int i = 0; i < makeDiagonalElementsZero(array_2).length; i++) {
            for (int j = 0; j < makeDiagonalElementsZero(array_2).length; j++) {
                System.out.print(makeDiagonalElementsZero(array_2)[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("Максимальный элемент в массиве = " + findMax(array_1));
        System.out.println("Сумма элементов второй строки = " + secondRowSum(array_1));
        fillArrayInSpiral(array_3);
        for (int i = 0; i < fillArrayInSpiral(array_3).length; i++) {
            for (int j = 0; j < fillArrayInSpiral(array_3)[i].length; j++) {
                System.out.print(fillArrayInSpiral(array_3)[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * @param array two-dimensional array
     * @return Sum of positive numbers for two-dimensional array
     */
    public static int simOfPositiveElements(int[][] array) {
        int simOfPositiveElements = 0;
        for (int[] i : array) {
            for (int element : i) {
                if (element > 0) {
                    simOfPositiveElements += element;
                }
            }
        }
        return simOfPositiveElements;
    }

    /**
     * @param size square's size
     */
    public static void printUserDimensionSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    /**
     * @param array two-dimensional array
     * @return array with zeros instead of diagonal elements
     */
    public static int[][] makeDiagonalElementsZero(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || i == array.length - 1 - j) {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

    /**
     * @param array two-dimensional array
     * @return maximum value in the array
     */
    public static int findMax(int[][] array) {
        int maxValue = array[0][0];
        for (int[] i : array) {
            for (int j : i) {
                if (j > maxValue) {
                    maxValue = j;
                }
            }
        }
        return maxValue;
    }

    /**
     * @param array two-dimensional array
     * @return sum of the second row elements
     */
    public static int secondRowSum(int[][] array) {
        int secondRowSum = 0;
        if (array.length < 2) {
            return -1;
        }
        for (int i : array[1]) {
            secondRowSum += i;
        }
        return secondRowSum;
    }

    /**
     *
     * @param array two-dimensional array
     * @return two-dimensional array filled with consecutive numbers in a spiral
     */
    public static int[][] fillArrayInSpiral(int[][] array) {
        int top = 0;
        int bottom = array.length;
        int left = 0;
        int right = array[0].length;
        int number = 0;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                array[top][i] = number++;
            }
            top++;
            for (int i = top; i < bottom; i++) {
                array[i][right - 1] = number++;
            }
            right--;
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    array[bottom - 1][i] = number++;
                }
                bottom--;
            }
            if (left < right) {
                for (int i = bottom - 1; i >= top; i--) {
                    array[i][left] = number++;
                }
                left++;
            }
        }
        return array;
    }
}
