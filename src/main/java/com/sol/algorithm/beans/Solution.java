package com.sol.algorithm.beans;

public interface Solution {
    void solve();

    default void println(String s) {
        System.out.println(s);
    }

    default void print(String s) {
        System.out.print(s);
    }
}
