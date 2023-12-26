package Lab4;

import java.util.Random;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(21);
            System.out.println(arr[i] + " ");
        }
        System.out.println("Nhap x: ");
        int x = scanner.nextInt();
        System.out.println("so lan xuat hien: " + yc1(x, arr));
        yc2(x, arr);
        scanner.close();
    }

    static int yc1(int x, int[] arr) {
        int count = 0;
        for (int number : arr) {
            if (number == x) {
                count++;
            }
        }
        return count;
    }

    static void yc2(int x, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = yc1(arr[i], arr);
            if (count >= 3) {
                System.out.println("Phan tu lap tren 2 lan: " + arr[i]);
            }
        }
    }
}

