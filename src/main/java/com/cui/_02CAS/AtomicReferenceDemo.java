package com.cui._02CAS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User {
    String userName;
    int age;
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("Z3", 23);
        User l4 = new User("L4", 24);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t当前用户为：" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(l4, z3) + "\t当前用户为：" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t当前用户为：" + atomicReference.get());
    }
}

