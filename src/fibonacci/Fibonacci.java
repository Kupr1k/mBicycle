package fibonacci;

//Написать программу для вывода серии чисел Фибоначчи

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Введите требуемое количество элементов последовательности Фибоначчи: ");
        fibonacci(new Scanner(System.in).nextInt());
    }

    private static void fibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }
}
