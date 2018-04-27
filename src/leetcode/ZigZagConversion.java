package leetcode;

import java.util.Arrays;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows <= 1){
            return s;
        }
        StringBuilder[] builders = new StringBuilder[numRows];
        Arrays.setAll(builders, value -> new StringBuilder());
        int delta = 2 * (numRows - 1);
        for (int i=0, j;i<s.length();i++){
            j = i % delta;
            if (j < numRows){
                builders[j].append(s.charAt(i));
            } else {
                builders[delta - j].append(s.charAt(i));
            }
        }
        return String.join("", builders);
    }
}
