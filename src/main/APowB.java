package main;

import java.util.ArrayList;
import java.util.List;

public class APowB {

    public double pow(double x, int n){
        int posAFlag = (x > 0 || n % 2 == 0)? 1 : -1, posBFlag = n > 0 ? 1 : -1;
        double posA = Math.abs(x);
        long posB = n == Integer.MIN_VALUE ? 0x80000000L : Math.abs(n);
        List<Integer> list = new ArrayList<>();
        while(posB > 0){
            list.add((int) (posB % 2));
            posB = posB / 2;
        }
        double target = 1D;
        for (int i=list.size()-1;i>=0;i--){
            target = target * target;
            if (list.get(i) > 0){
                target = target * posA;
            }
        }
        target = target * posAFlag;
        System.out.println(target);
        if (posBFlag > 0){
            return target;
        } else {
            return 1 / target;
        }
    }
}
