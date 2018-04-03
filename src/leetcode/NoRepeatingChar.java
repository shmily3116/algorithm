package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class NoRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, maxCount = 0;
        for (int i=0;i<s.length() - 1;i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                int start  = map.get(c);
                map.clear();
                for (int j=start;j<=i;j++){
                    map.put(s.charAt(j), j);
                }
                maxCount = i - start;
            } else {
                map.put(c, i);
                maxCount++;
            }
            count = Math.max(count, maxCount);
        }
        return count;
    }

    public static void main(String[] args){
        NoRepeatingChar nrc = new NoRepeatingChar();
        System.out.println(nrc.lengthOfLongestSubstring("bbbbb"));
        System.out.println(nrc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(nrc.lengthOfLongestSubstring("pwwkew"));
        System.out.println(nrc.lengthOfLongestSubstring("dvdf"));
        System.out.println(nrc.lengthOfLongestSubstring("c"));
    }
}
