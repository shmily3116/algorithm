package main;

import search.AbstractSearch;
import search.BinarySearch;
import search.ModBinarySearch;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args){
        System.out.println(new APowB().pow(2D, 2147483647));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder();
        for (int i=0;;i++){
            Character c = null;
            for (int j=0;j<strs.length;j++){
                if (i >= strs[j].length()){
                    return str.toString();
                }
                if (c == null){
                    c = strs[j].charAt(i);
                } else if (c != strs[j].charAt(i)){
                    return str.toString();
                }
            }
            str.append(c);
        }
    }
}
