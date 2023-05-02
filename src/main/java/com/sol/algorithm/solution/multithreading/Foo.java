package com.sol.algorithm.solution.multithreading;

import java.util.concurrent.Semaphore;

class Foo {
    Semaphore s12 = new Semaphore(0);
    Semaphore s23 = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s12.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s12.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s23.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        s23.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}