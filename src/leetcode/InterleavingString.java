package leetcode;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    public static void main(String[] args) {
        InterleavingString ils = new InterleavingString();
        String s1="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
        s2="babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
        s3="babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        System.out.println(ils.isInterleave(s1, s2, s3));
        System.out.println(ils.count);
    }

    public int count = 0;
    private Map<String, Boolean> checkCache = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null){
            return false;
        }
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        return check(s1,0, s2, 0, s3, 0);
    }

    private boolean check(String s1, int i1, String s2, int i2, String s3, int i3){
        count++;
        Boolean ck;
        String key = i1+","+i2;
        if ((ck = checkCache.get(key)) != null){
            return ck;
        }
        if (s1.length() == 0){
            ck = s2.equals(s3);
        } else if (s2.length() == 0){
            ck = s1.equals(s3);
        } else {
            ck = ((s1.charAt(i1) == s3.charAt(i3)) && check(s1, ++i1, s2, i2, s3, ++i3))
                    || ((s2.charAt(i2) == s3.charAt(i3)) && check(s1, i1, s2, ++i2, s3, ++i3));
        }
        checkCache.put(key, ck);
        return ck;
    }
}
