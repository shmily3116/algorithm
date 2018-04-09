package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatingChar {

    /**
     * 关键：起始结束位置
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, lastStart = -1;
        Integer start;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((start = map.get(c)) != null) {
                lastStart = Math.max(start, lastStart);
            }
            map.put(c, i);
            count = Math.max(count, i - lastStart);
        }
        return count;
    }

    public int lengthOfLongestSubstringV2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int start = map.get(c);
                map.clear();
                for (int j = start; j <= i; j++) {
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
