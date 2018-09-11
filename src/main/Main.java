package main;

import search.AbstractSearch;
import search.BinarySearch;
import search.ModBinarySearch;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){
        Random random = new Random();

        List<Integer> list = random.ints(20, 0, 10000).boxed().collect(Collectors.toList());

        int sum = 0;
        for (Integer i : list){
            sum += i;
        }

        System.out.println(sum);

        int sumStream = list.stream().reduce(0, Integer::sum);

        System.out.println(sumStream);

        List<Integer> result = new ArrayList<>();

        for (Integer i : list){
            if (i > 20){
                result.add(i);
            }
        }

        result = list.stream().filter(i -> i>20).collect(Collectors.toList());
        list.stream().distinct().collect(Collectors.toList());
        System.out.println(result);
    }

    public void test(){

        Thread t0 = new Thread(this::doSomething);
    }

    private void doSomething(){


    }
}
