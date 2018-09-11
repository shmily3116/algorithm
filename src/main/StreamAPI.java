package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        new StreamAPI().sleepTest();
    }

    public void sort(){
        Random random = new Random();
        List<List<Integer>> datas = new ArrayList<>();
        for (int i=0;i<10000;i++){
            datas.add(Stream.generate(random::nextInt).limit(1000).collect(Collectors.toList()));
        }
        long start = System.currentTimeMillis();
        datas.forEach(Collections::sort);
        long end = System.currentTimeMillis();
        System.out.println("end - start:" + (end - start));
        datas = new ArrayList<>();
        for (int i=0;i<10000;i++){
            datas.add(Stream.generate(random::nextInt).limit(1000).collect(Collectors.toList()));
        }
        start = System.currentTimeMillis();
        datas.parallelStream().forEach(Collections::sort);
        end = System.currentTimeMillis();
        System.out.println("parallel end - start:" + (end - start));
    }

    public void sleepTest(){
        Random random = new Random();
        List<Integer> list = Stream.generate(random::nextInt).limit(1000).collect(Collectors.toList());
        long start = System.currentTimeMillis();
        list.forEach(this::sleep);
        long end = System.currentTimeMillis();
        System.out.println("end - start:" + (end - start));
        start = System.currentTimeMillis();
        list.parallelStream().forEach(this::sleep);
        end = System.currentTimeMillis();
        System.out.println("end - start:" + (end - start));
        List<Param> params = new ArrayList<>();

        Map<String, Param> data = new HashMap<>();
        params.parallelStream().forEach(p -> data.put(p.getName(), p));


        System.out.println(data);
    }

    private void sleep(int par){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Param{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
