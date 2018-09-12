package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        if (triangle.size() == 2) {
            return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));
        }
        List<Integer> inter = new ArrayList<>();
        for (int i : triangle.get(1)){
            inter.add(i + triangle.get(0).get(0));
        }
        for (int i = 2; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            List<Integer> nextInter = new ArrayList<>();
            nextInter.add(cur.get(0) + inter.get(0));
            for (int j = 1; j < cur.size() - 1; j++) {
                nextInter.add(cur.get(j) + Math.min(inter.get(j-1), inter.get(j)));
            }
            nextInter.add(cur.get(cur.size()-1) + inter.get(inter.size()-1));
            inter = nextInter;
        }
        return inter.stream().min(Integer::compare).orElse(0);
    }
}
