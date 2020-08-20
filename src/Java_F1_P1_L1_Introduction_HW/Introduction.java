package Java_F1_P1_L1_Introduction_HW;

public class Introduction {
    public static void main(String[] args) {
        /**
         * 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
         */
        byte bt = 23;
        short sh = 670;
        int in = -897;
        long ln = 90876L;
        float fl = 4.89f;
        double db = 6.90453;
        boolean bl = true;
        char ch = 'u';

        /**
         * 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
         * где a, b, c, d – входные параметры этого метода;
         */
        double a = 1;
        double b = 2;
        double c = 3;
        double d = 4;
        if (d != 0) {
            double result3 = calc(a, b, c, d);
            System.out.println(a + " * (" + b + " + (" + c + " / " + d + ")) = " + result3);
        } else {
            System.out.println("На ноль делить нельзя!");
        }

        /**
         *  4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
         *  в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
         */
        int e = 5;
        int f = 7;
        boolean result4 = isSummRight(e, f);
        System.out.println(result4);

        /**
         * 5. Написать метод, которому в качестве параметра передается целое число, метод должен
         * напечатать в консоль положительное ли число передали, или отрицательное; Замечание:
         * ноль считаем положительным числом.
         */
        int g = -69;
        numberPositiveOrNegative(g);

        /**
         * 6. Написать метод, которому в качестве параметра передается целое число, метод должен
         * вернуть true, если число отрицательное;
         */
        int h = -9;
        boolean result6 = isNegative(h);
        System.out.println(result6);

        /**
         * 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
         * метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
         */
        String name = "Алиса";
        printName(name);

        /**
         * 8. Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
         * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
         */
        int year = 2003;
        leapYear(year);


    }

    // Метод задачи №3
    private static double calc(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    // Метод задачи №4
    private static boolean isSummRight(int e, int f) {
        return ((10 <= (e + f)) && (e + f) <= 20);
    }

    // Метод задачи №5
    private static void numberPositiveOrNegative(int g) {
        if (g < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    // Метод задачи №6
    private static boolean isNegative(int h) {
        return (h < 0);
    }

    // Метод задачи №7
    private static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // Метод задачи №8
    private static void leapYear(int year) {
        if (year % 100 == 0 && year % 400 != 0 || year % 4 != 0) {
            System.out.println("Год не високосный");
        } else {
            System.out.println("Год високосный");
        }
    }

}
