package main;

import java.util.*;

public class ChangeForMore {

    public static void main(String[] args) {
        int[] moneys = {1,2,5,10,20,50,100};
        Map<Integer, List<List<Integer>>> answers = new HashMap<>();
        answers.put(0, Collections.emptyList());
        answers.put(1, Arrays.asList(Arrays.asList(1)));
        int target = 2, money = 0, f = 5, moneyCount = 1;
        while (target <= f){
            List<List<Integer>> curs = new ArrayList<>();
            if (target >= moneys[money + 1]){
                money++;
                moneyCount=1;
                if (target == moneys[money]){
                    curs.add(Collections.singletonList(moneys[money]));
                } else {
                    List<List<Integer>> tmp = answers.get(target - moneys[money]);
                    for (List<Integer> l : tmp){
                        List<Integer> t = new ArrayList<>(l);
                        t.add(moneys[money]);
                        curs.add(t);
                    }
                }
            } else {
                if (target == moneys[money] * (moneyCount+1)){
                    List<Integer> list = new ArrayList<>(moneyCount + 1);
                    Collections.fill(list, moneys[money]);
                    curs.add(list);
                    moneyCount++;
                }
                for (List<Integer> l : answers.get(target-1)){
                    List<Integer> t = new ArrayList<>();
                    t.add(1);
                    t.addAll(l);
                    curs.add(t);
                }
            }
            answers.put(target, curs);
            target++;
        }
        System.out.println(answers.values());
    }
}
