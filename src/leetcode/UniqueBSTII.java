package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBSTII {

    public static void main(String[] args) {
        UniqueBSTII unique = new UniqueBSTII();
        unique.generate(5);
    }

    public void generate(int n){
        if (n <= 0){
            return;
        }
        List<Integer> first = Collections.emptyList();
        List<List<Integer>> oldList = new ArrayList<>();
        List<List<Integer>> newList = new ArrayList<>();
        oldList.add(first);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            newList = new ArrayList<>();
            for (List<Integer> list : oldList){
                for (int j=0;j<list.size();j++){
                    List<Integer> newGen = new ArrayList<>(list.subList(0, j));
                    newGen.add(i);
                    newGen.addAll(list.subList(j, list.size()));
                    newList.add(newGen);
                    count++;
                }
                List<Integer> newGen = new ArrayList<>(list);
                newGen.add(i);
                newList.add(newGen);
            }
            oldList = newList;
        }
        System.out.println(newList);
        System.out.println(newList.size());
        System.out.println(count);
        newList = new ArrayList<>();
        for (List<Integer> list : oldList){
            for (int i = 0; i < list.size(); i++) {
                
            }
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
