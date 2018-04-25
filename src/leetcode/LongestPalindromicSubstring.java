package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文字串
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args){
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("abba"));
        System.out.println(lps.longestPalindrome1("abba"));
        System.out.println(lps.longestPalindrome("babad"));
        System.out.println(lps.longestPalindrome1("babad"));
        System.out.println(lps.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(lps.longestPalindrome1("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public String longestPalindrome(String s) {
        int maxCount=0, start=0, end=0, count=0;
        Map<String, Boolean> checkMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            for (int j=i+1;j<s.length();j++){
                boolean flag = true;
                int left=i, right=j;
                while(left<=right){
                    if (s.charAt(left) != s.charAt(right)
                            || Boolean.FALSE.equals(checkMap.get(i+"+"+j))){
                        flag = false;
                        break;
                    } else {
                        left++;
                        right--;
                        count++;
                    }
                }
                checkMap.put(i+"+"+j, flag);
                if (flag && maxCount < (j-i+1)){
                    start = i;
                    end = j;
                    maxCount = j - i + 1;
                }
            }
        }
        //System.out.println(count);
        return s.substring(start, end+1);
    }

    private int lo, maxLen;
    public String longestPalindrome1(String s) {
        lo=0;
        maxLen=0;
        if (s.length() < 2){
            return s;
        }
        for(int i=0;i<s.length();i++){
            search(s, i, i);
            search(s, i, i+1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void search(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if (r-l-1>maxLen){
            lo = l+1;
            maxLen = r-l-1;
        }
    }
}
