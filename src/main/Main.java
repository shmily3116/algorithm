package main;

import search.AbstractSearch;
import search.BinarySearch;
import search.ModBinarySearch;

public class Main {

    public static void main(String[] args){
        AbstractSearch as = new ModBinarySearch();
        for (int i=0;i<20;i++) {
            as.search(10);
        }
    }
}
