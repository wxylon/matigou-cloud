package com.matigou.common;


@FunctionalInterface
public interface FunInterface {
    abstract void test(Integer i);

    static void t1(){}

    default void t3(){}
}
