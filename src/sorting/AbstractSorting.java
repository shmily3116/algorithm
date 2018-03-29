package sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class AbstractSorting {

    private Random random = new Random();

    private Integer[] generateArrays(int num){
        return Stream.generate(() -> random.nextInt(10000)).limit(num).collect(Collectors.toList()).toArray(new Integer[]{});
    }

    private boolean checkArrays(Integer[] sortedArrays){
        for (int i=0;i<sortedArrays.length-1;i++){
            if (sortedArrays[i] > sortedArrays[i + 1]){
                return false;
            }
        }
        return true;
    }

    public Integer[] sort(int num){
        Integer[] toSortArr = generateArrays(num);
        System.out.println("to be : "+ Arrays.toString(toSortArr));
        toSortArr = actualSort(toSortArr);
        System.out.println("sorted: "+ Arrays.toString(toSortArr));
        System.out.println("check if sorted: "+checkArrays(toSortArr));
        return toSortArr;
    }

    protected abstract Integer[] actualSort(Integer[] arrays);
}
