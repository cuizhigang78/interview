package _100_written_test;

/**
 * 题目如下：
 *     用 1、2、2、3、4、5 这六个数字，
 *     用 java 写一个 main 函数，打印出所有不同的排列，
 *     如： 512234、412345等，要求：”4”不能在第3位，”3”与”5”不能相连。
 */
public class NumberCombineDemo {
    /**
     * 分析：
     * 1.不考虑条件，一共会产生多少个数字
     * 2.去筛选数字，满足要求的留下来
     * 3.将数字int类型转为String类型，利用String的方法来筛选,具体看API
     */
    public static void main(String[] args) {
        int count = 0;
        for (int i = 122345; i <= 543221; i++) {
           if (someMethod(String.valueOf(i))) {
               System.out.println(i);
               count++;
           }
        }
        System.out.println("共有：" + count + "个");
    }

    private static boolean someMethod(String str) {
        String[] array = {"1", "2", "2", "3", "4", "5"};
        for (String s : array) {
            if(!str.contains(s)) {
                return false;
            }
        }

        if(str.indexOf("2") == str.lastIndexOf("2")) {
            return false;
        }

        if (str.indexOf("4") == 2) {
            return false;
        }

        if (str.contains("35") || str.contains("53")) {
            return false;
        }
        return true;
    }
}





















