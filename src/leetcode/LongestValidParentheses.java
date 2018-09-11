package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author daojia
 * @date 2018-8-3.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses vip = new LongestValidParentheses();
        System.out.println(vip.find("()(()"));
        System.out.println(vip.find(")()())"));
        System.out.println(vip.find("(((()())"));
    }

    public int longestValidParentheses(String s) {
        int count = 0;
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<s.length();j++){
                if (check(s, i, j) && (j-i)>count){
                    count = j-i+1;
                }
            }
        }
        return count;
    }

    private boolean check(String s, int start, int end){
        Deque<Character> queue = new LinkedList<>();
        for (int i = start; i <= end; i++){
            Character cc;
            char c = s.charAt(i);
            switch (c){
                case '(':
                    queue.add(c);
                    break;
                case ')':
                    if ((cc = queue.pollLast()) == null || cc != '('){
                        return false;
                    }
                    break;
            }
        }
        return queue.size() == 0;
    }

    private int find(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        Deque<Character> list = new LinkedList<>();
        Deque<Integer> pos = new LinkedList<>();
        int start = 0, end = 0, count = 0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch (c){
                case '(':
                    list.offer(c);
                    pos.offer(i);
                    break;
                case ')':
                    Character lastC = list.pollLast();
                    Integer lastP = pos.pollLast();
                    if (lastC == null || lastC != '(') {
                        count = Math.max(count, end - start);
                        end = start = i;
                    }else if ((i - lastP) % 2 == 0){
                        start = lastP + 1;
                    } else {
                        end += 2;
                    }
            }
        }
        return Math.max(count ,end - start);
    }
}
