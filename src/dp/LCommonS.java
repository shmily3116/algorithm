package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LCommonS {

    public static void main(String[] args) {
        LCommonS lcs = new LCommonS();
        /*String abcs = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i=0;i<26;i++){
            sb.append(abcs.charAt(random.nextInt(26)));
        }
        String s1 = sb.toString();
        sb = new StringBuilder();
        for (int i=0;i<26;i++){
            sb.append(abcs.charAt(random.nextInt(26)));
        }
        String s2 = sb.toString();
        System.out.println(s1);
        System.out.println(s2);*/
        System.out.println(lcs.find("zhahzkikoawleh", "zdfllkyjdxb"));
        System.out.println(lcs.count);
        System.out.println(Math.log(lcs.count)/Math.log(2));
        System.out.println(lcs.findInverse("zhahzkikoawleh", "zdfllkyjdxb"));
    }
    private int count = 0;
    public String find(String s1, String s2){
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
            return "";
        }
        return find(s1, s1.length()-1, s2, s2.length()-1);
    }

    private String find(String s1, int p1, String s2, int p2){
        if (p1 == -1 || p2 == -1){
            return "";
        }
        //System.out.println(p1 + "," + p2);
        count++;
        if (s1.charAt(p1) == s2.charAt(p2)){
            return find(s1, p1-1, s2, p2-1) + s1.charAt(p1);
        } else {
            String ss0 = find(s1, p1, s2, p2-1);
            String ss1 = find(s1, p1-1, s2, p2);
            return ss0.length() > ss1.length() ? ss0 : ss1;
        }
    }

    public String findInverse(String s1, String s2){
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
            return "";
        }
        if (s1.length() < s2.length()){
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        String[] cache = new String[s2.length()];
        String last;
        Arrays.fill(cache, "");
        for (int i=0;i<s1.length();i++){
            last = cache[0];
            cache[0] = "";
            if (s1.charAt(i) == s2.charAt(0)){
                cache[0] = s1.charAt(i) + "";
            }
            for (int j=1;j<s2.length();j++){
                String tmp = cache[j];
                if (s1.charAt(i) == s2.charAt(j)){
                    //(i-1,j-1)
                    cache[j] = last + s1.charAt(i);
                } else {
                    //(i,j-1)
                    if (cache[j].length() < cache[j-1].length()){
                        cache[j] = cache[j-1];
                    }
                    //(i-1,j)
                }
                last = tmp;
            }
            System.out.println(Arrays.toString(cache));
        }
        return cache[s2.length() - 1];
    }
}
