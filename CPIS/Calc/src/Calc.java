import java.util.Scanner;

import static java.lang.Math.*;

public class Calc {

    public static void println(Object line) {
        System.out.println(line);
    }

    public static void ext(){
        println("Введите 1, если хотите продолжить, или 0, если хотите выйти из программы");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();

        switch (n) {
            case (0) -> System.exit(1);
            case (1) -> menu();
        }
    }

    public static double input() {
        println("Введите число: ");
        Scanner number = new Scanner(System.in);
        return number.nextDouble();
    }



    public static void output(double res) {
        println("Результат выражения: " + res);
        ext();
    }

    public static void Addition() {
        println("Вы выбрали сложение");
        double a = input();
        double b = input();
        double res = a + b;
        output(res);
    }

    public static void Subtraction() {
        println("Вы выбрали вычитание");
        double a = input();
        double b = input();
        double res = a - b;
        output(res);
    }

    public static void Multiplication() {
        println("Вы выбрали умножение");
        double a = input();
        double b = input();
        double res = a - b;
        output(res);
    }

    public static void Division() {
        println("Вы выбрали деление");
        double a = input();
        double b = input();
        double res = a / b;
        output(res);
    }

    public static void Exponentiation() {
        println("Вы выбрали возведение в степень");
        double a = input();
        double b = input();
        double res = pow(a, b);
        output(res);
    }

    public static void Sqrt() {
        println("Вы выбрали корень");
        double a = input();
        double res = sqrt(a);
        output(res);
    }

    public static void Comparison() {
        println("Вы выбрали сравнение чисел");
        double a = input();
        double b = input();
        if (a > b) {
            println("Число a больше числа b на " + (a - b));
        } else {
            println("Число b больше числа a на " + (b - a));
        }
        ext();
    }

    public static void Logarithm() {
        println("Вы выбрали логарифм числа");
        double a = input();
        double res = log(a);
        output(res);
    }

    public static void Equality() {
        println("Вы выбрали сравнение");
        double a = input();
        double b = input();
        if (a == b) {
            println("Числа равны");
        } else {
            println("Числа не равны");
        }
        ext();
    }

    public static void menu() {
        println(
                """
                         1) Сложение
                         2) Вычитание
                         3) Умножение
                         4) Деление
                         5) Возведение в степень
                         6) Корень числа
                         7) Процент от числа
                         8) Логарифм числа
                         9) Равенство чисел
                        """
        );

        println("Введите номер действия: ");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();

        switch (n) {
            case (1) -> Addition();
            case (2) -> Subtraction();
            case (3) -> Multiplication();
            case (4) -> Division();
            case (5) -> Exponentiation();
            case (6) -> Sqrt();
            case (7) -> Comparison();
            case (8) -> Logarithm();
            case (9) -> Equality();
        }

    }

    public static void main(String[] args) {
        menu();
    }
}