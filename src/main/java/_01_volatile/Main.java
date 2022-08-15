package _01_volatile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                try {
                    long input = scanner.nextLong();
                    if (input > 0) {
                        System.out.println("input = " + input);
                    } else {
                        System.out.println("ERROR");
                    }

                    long bigger = input + 1;
                    while (!duiCheng(bigger)) {
                        bigger++;
                    }

                    long smaller = input - 1;
                    while (!duiCheng(smaller) && smaller >= 11) {
                        smaller--;
                    }

                    System.out.println("bigger = " + bigger);
                    System.out.println("smaller = " + smaller);

                    if (smaller >= 11) {
                        if (bigger - input > input - smaller) {
                            System.out.println(smaller);
                        } else if (bigger - input < input - smaller) {
                            System.out.println(bigger);
                        } else {
                            System.out.println(smaller + "," + bigger);
                        }
                    } else {
                        System.out.println(bigger);
                    }


                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            }
        }
    }

    /**
     * 判断num是否对称
     */
    private static boolean duiCheng(long num) {
        if (num < 11) {
            return false;
        }
        String str = String.valueOf(num);
        // 字符串长度
        int length = str.length();
        // 中间字符下标
        int mid;
        if ((length | 1) == length) {
            // 长度为奇数 101
            mid = (length - 1) / 2;
            for (int i = 0, j = length - 1; i < mid && j > mid; i++, j--) {
                if (str.getBytes()[i] != str.getBytes()[j]) {
                    return false;
                }
            }
        } else {
            // 长度为偶数
            mid = length / 2 - 1;
            for (int i = 0, j = length - 1; i <= mid && j > mid; i++, j--) {
                if (str.getBytes()[i] != str.getBytes()[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
