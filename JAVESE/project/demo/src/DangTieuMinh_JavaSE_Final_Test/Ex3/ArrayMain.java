package DangTieuMinh_JavaSE_Final_Test.Ex3;

import java.lang.module.FindException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayMain {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap so phan tu cua mang: ");
            int n = scanner.nextInt();

            int[] mang = new int[n];
            System.out.print("Nhap cac phan tu cua mang: ");
            for (int i = 0; i < n; i++) {
                mang[i] = scanner.nextInt();
            }

            int soXuatHienNhieuNhat = timSoXuatHienNhieuNhat(mang);
            System.out.println("Input: ");
            show(mang);
            System.out.println("\nOutput: \nSo nguyen xuat hien nhieu lan nhat trong mang la: " + soXuatHienNhieuNhat);

        }
    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


        private static int timSoXuatHienNhieuNhat(int[] mang) {
            Map<Integer, Integer> demSoLanXuatHien = new HashMap<>();

            for (int so : mang) {
                if (demSoLanXuatHien.containsKey(so)) {
                    demSoLanXuatHien.put(so, demSoLanXuatHien.get(so) + 1);
                } else {
                    demSoLanXuatHien.put(so, 1);
                }
            }

            int soXuatHienNhieuNhat = mang[0];
            int soLanXuatHienNhieuNhat = demSoLanXuatHien.get(mang[0]);

            for (int so : demSoLanXuatHien.keySet()) {
                int soLanXuatHien = demSoLanXuatHien.get(so);
                if (soLanXuatHien > soLanXuatHienNhieuNhat) {
                    soXuatHienNhieuNhat = so;
                    soLanXuatHienNhieuNhat = soLanXuatHien;
                }
            }

            return soXuatHienNhieuNhat;
        }

    }
