package sorting;

import java.util.Arrays;

public class InsertionSorting extends AbstractSorting {

    public Integer[] sort(int num){
        Integer[] toSortArr = generateArrays(num);
        System.out.println("to be sorted: "+ Arrays.toString(toSortArr));


        return toSortArr;
    }
}
