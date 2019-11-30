package com.cui._02CAS;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题的解决
 */
public class AtomicStampedReferenceDemo {

    public static void main(String[] args) {
        System.out.println("======以下是ABA问题的产生======");
        AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
        // 先改成101
        atomicReference.compareAndSet(100, 101);
        // 再改回去
        atomicReference.compareAndSet(101, 100);
        // 再执行CAS
        System.out.println("是否修改成功：" + atomicReference.compareAndSet(100, 101) + "\t当前实际值为：" + atomicReference.get());

        System.out.println("======以下是ABA问题的解决======");
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
        // 先改成101 此时版本号由1 -> 2
        atomicStampedReference.compareAndSet(100, 101,
                1, atomicStampedReference.getStamp() + 1);
        // 再改回去 此时版本号由2 -> 3
        atomicStampedReference.compareAndSet(101, 100,
                2, atomicStampedReference.getStamp() + 1);
        // 再执行CAS
        boolean success = atomicStampedReference.compareAndSet(100, 101,
                3, atomicStampedReference.getStamp() + 1);
        System.out.println("是否修改成功：" + success +
                "\t当前实际值为：" + atomicStampedReference.getReference() +
                "\t当前版本号为：" + atomicStampedReference.getStamp());
    }
}
