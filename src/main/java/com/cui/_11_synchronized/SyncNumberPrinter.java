package com.cui._11_synchronized;

public class NumberPrinter {
    private int times = 8;
    private int times1 = isOdd(times)? times / 2 + 1 : times / 2;
    private int prev = 2;
    private int nextNumber = 1;
    // 奇数
    private boolean isOdd(int i) {
        return (i & 1) == 1;
    }
    // 偶数
    private boolean isEven(int i) {
        return !isOdd(i);
    }

    synchronized public void printZero() throws InterruptedException {
        for (int i = 0; i < times; i++) {
            while (prev == 0) {
                wait();
            }
            System.out.print(0);
            prev = 0;
            notifyAll();
        }
    }
    synchronized public void printOne() throws InterruptedException {
        for (int i = 0; i < times1; i++) {
            while (prev != 0 || isEven(nextNumber)) {
                wait();
            }
            System.out.print(nextNumber);
            prev = nextNumber;
            nextNumber++;
            notifyAll();
        }
    }
    synchronized public void printTwo() throws InterruptedException {
        for (int i = 0; i < times / 2; i++) {
            while (prev != 0 || isOdd(nextNumber)) {
                wait();
            }
            System.out.print(nextNumber);
            prev = nextNumber;
            nextNumber++;
            notifyAll();
        }
    }
}
