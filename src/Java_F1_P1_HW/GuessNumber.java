package Java_F1_P1_HW;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class GuessNumber {
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

        /**
         * 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается
         * 3 попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное
         * пользователем число чем загаданное, или меньше. После победы или проигрыша выводится запрос –
         * «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
         */
        guessNumber();

        /**
         * 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot",
         * "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
         * "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
         * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
         * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не
         * угадано, компьютер показывает буквы которые стоят на своих местах.
         * apple – загаданное
         * apricot - ответ игрока
         * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
         * Для сравнения двух слов посимвольно, можно пользоваться:
         * String str = "apple";
         * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
         * Играем до тех пор, пока игрок не отгадает слово
         * Используем только маленькие буквы
         */
        guessWords();

    }

    private static void guessWords() {
        int n = 15; // количество символов в ответе
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Угадай, какое слово из предложенных загадано:\n" + Arrays.toString(words) + "\nПри неправильном ответе будут показываться буквы, которые стоят на своих местах");
        String wordX = words[random.nextInt(words.length)]; // выбор рандомного слова
        char[] x = initCharsArr(wordX, n); // инициализация загаданного слова: первые символы - само слово, остальные - #
        printCharsArr(x);
        game(x, n);
        System.out.println("Правильно! Ответ: " + wordX);
    }

    private static void game(char[] arrX, int n) {
        char[] showArr = new char[n]; // массив с символами, которые угадали
        String x; // эту строку мы вводим
        char[] arrSearch; // строка x в виде массива символов
        do {
            System.out.println("Введи слово:");
            x = sc.next();
            arrSearch = initCharsArr(x, n); // перевод строки х в массив символов. Инициализация слова для ответа: первые символы - само слово, остальные - #
            for (int i = 0; i < n; i++) { //инициализация показываемого массива с отгаданными буквами
                if (arrSearch[i] == arrX[i]) {
                    showArr[i] = arrX[i];
                } else {
                    showArr[i] = '#';
                }
            }
            printCharsArr(showArr); // печать массива
        }
        while (isEqual(arrSearch, arrX)); // выполнять ввод, пока загаданное слово не будет отгадано

    }

    private static boolean isEqual(char [] search, char [] x){ // равны ли строки
        String str = new String(search);
        String strX = new String(x);
        return (!str.equals(strX)); // не равны? - true
    }

    private static char[] initCharsArr(String charArr, int n) { // инициализация вводимых слов: "слово##########"
        char[] array = new char[n];
        for (int i = 0; i < array.length; i++) {
            if (i < charArr.length()) {
                array[i] = charArr.charAt(i);
            } else {
                array[i] = '#';
            }

        }
        return array;
    }

    private static void printCharsArr(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private static void guessNumber() {
        int repeat;
        int finish = 10;
        int x; // загаданное число в пределах от 0 до finish
        int searchX; // число для попытки найти загаданное число
        int count = 0; // количество использованных попыток
        int n = 3; // количество попыток
        System.out.printf("Загадано число в пределах от 0 до %d. Тебе нужно угадать его за %d попыток\n", finish - 1, n);
        do { // цикл для начала новой игры
            x = random.nextInt(finish);
            for (; count < n; count++) {
                System.out.printf("Попытка №%d:\n", count + 1);
                searchX = sc.nextInt();
                if (searchX == x) {
                    System.out.printf("Ты угадал! Загаданное число: %d\n", x);
                    break;
                }
                if (searchX < x) {
                    System.out.println("Больше!");
                } else {
                    System.out.println("Меньше!");
                }
            }
            if (count == n) {
                System.out.printf("Ты не угадал за 3 попытки! Загаданное число: %d\n", x);
            }
            count = 0;


            while (true) { //цикл необходим для предотвращения написания других чисел
                System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»");
                repeat = sc.nextInt();
                if (repeat == 0 || repeat == 1) {
                    break;
                } else {
                    System.err.println("Неверный ввод");
                }
            }
        }
        while (repeat == 1);

    }
}
