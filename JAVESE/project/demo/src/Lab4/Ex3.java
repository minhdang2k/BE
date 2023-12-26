package Lab4;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = scanner.nextInt();
        System.out.print("Nhap cac phan tu cua mang: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("So lon nhat trong mang la : " + yc1(n, arr));
        System.out.println("So be nhat trong mang la : " + yc2(n, arr));
        System.out.println("Trung binh cong cac so trong mang : " + yc3(n, arr));
        System.out.println("So nguyen to co trong mang la  : " + yc4(n, arr));
        scanner.close();
    }

    static int yc1(int n, int[] arr) {
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static int yc2(int n, int[] arr) {
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    static int yc3(int n, int[] arr) {
        int sum = 0;
        int avg = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];

        }
        avg = sum / n;

        return avg;
    }

    static int yc4(int n, int[] arr) {
        int snt = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] % 1 == 0 && arr[i] % arr[i] == 0) {
                snt = arr[i];
            }
        }
        return snt;
    }
}