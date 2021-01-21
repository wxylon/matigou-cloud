package com.matigou.common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTests {

    @Test
    public void test(){
        List<Integer> integers = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            integers.add(i);
        }

        Predicate<Integer> predicate = (i) -> i > 50;
        predicate.and((i) -> i < 60);

        integers.stream().filter((i) -> i > 50).filter((i) -> i < 60).forEach(System.out :: println);





        FunInterface funInterface = ((i) -> {System.out.println(i);});

        System.out.println(new Thread(() -> {System.out.println(11);}));

        Function<Integer, String> f = new Function<Integer,String>(){
            @Override
            public String apply(Integer t) {
                return (t+1) + "";
            }
        };

        f.apply(1);









        Function<Integer, String> f2 = (t)->String.valueOf(t);
        //3. 使用方法引用的方式
        Function<Integer, String> f1 = String::valueOf;
    }

}
