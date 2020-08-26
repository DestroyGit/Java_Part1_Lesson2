package Java_F1_P1_HW;

import java.util.Arrays;
import java.util.Random;

public class CyclesAndArrays {
    public static void main(String[] args) {
        Random random = new Random();

        /**
         * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
         * [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */

        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                arr1[i] = 0;
            } else {
                arr1[i] = 1;
            }
        }
        printArray(arr1);

        /**
         * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
         * значениями 0 3 6 9 12 15 18 21;
         */
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        printArray(arr2);

        /**
         * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
         * и числа меньшие 6 умножить на 2;
         */

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        printArray(arr3);

        /**
         * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
         * одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        int n = 8; //количество строк и столбцов квадратного массива
        int[][] arr4 = new int[n][n];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j || i + j == arr4.length - 1) {
                    arr4[i][j] = 1;
                }
            }

        }
        printArray(arr4);

        /**
         * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы;
         */
        int[] arr5 = new int[7];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt(200) - 100; //заполнение массива рандомными числами от -100 до 100
        }
        printArray(arr5);
        System.out.println("Минимальное число в массиве: " + minimum(arr5) + "\nМаксимальное число в массиве: " + maximum(arr5));

        /**
         * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив метод должен
         * вернуть true, если в массиве есть место, в котором сумма левой и право части массива равны. Примеры:
         * checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
         * граница показана символами ||, эти символы в массив не входят.
         */

        int[] arr6 = {1,2,4};
        System.out.println(isBalance(arr6));

        /**
         * 7. **** Написать метод, которому на вход подается одномерный массив и число m (может быть положительным,
         * или отрицательным), при этом метод должен сместить все элементымассива на m позиций. Для усложнения задачи
         * нельзя пользоваться вспомогательными массивами.
         */

        int[] arr7 = {1, 2, 3, 4, 5};
        int m = -3;
        arr7 = changeArr(arr7, m);
        printArray(arr7);

    }

    private static void printArray(int[] array) { //печать одномерного массива
        System.out.println(Arrays.toString(array));
    }

    private static void printArray(int[][] array) { //печать двумерного массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    private static int minimum(int[] array) { //метод нахождения минимального числа в одномерном массиве
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static int maximum(int[] array) { //метод нахождения максимального числа в одномерном массиве
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static boolean isBalance(int[] array) {
        int left = 0; //сумма левой части
        int right = 0; //сумма правой части
        int count = 0; //счетчик цикла
        for (int i = 0, j = array.length - 1; count != array.length; count++) {
            if (left <= right) {
                left += array[i];
                i++;
            } else {
                right += array[j];
                j--;
            }
        }
        return left == right;
    }

    private static int[] changeArr(int[] array, int m) { //метод смещения элементов массива
        for (int i = 0; i < modul(m); i++) { //высчитываем модуль числа m
            if (m > 0) {
                int memory = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = memory;
            }
            if (m < 0) {
                int memory = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = memory;
            }
        }
        return array;
    }

    private static int modul(int m) { //метод нахождения модуля числа
        if (m >= 0) {
            return m;
        } else {
            return m - 2 * m;

        }
    }
}
