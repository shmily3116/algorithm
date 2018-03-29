package search;

import java.util.Random;

public class ModBinarySearch extends AbstractSearch {

    @Override
    protected Integer actualSearch(Integer[] arrays, int target) {
        int low = 0, high = arrays.length - 1, mid = (low + high) / 2;
        while (mid != low){
            if (arrays[mid] == target){
                return mid;
            }
            if (arrays[high] == target){
                return high;
            }
            if (arrays[mid] < target){
                if (arrays[high] > arrays[mid]){
                    // 正常情况
                    low = mid;
                } else {
                    // 特殊情况
                    high = (mid + high) / 2;
                }
            } else {
                if (arrays[low] < arrays[mid]){
                    high = mid;
                } else {
                    low = (low + mid) / 2;
                }
            }
            mid = (low + high) / 2;
        }
        return -1;
    }

    @Override
    protected Integer[] dealArrays(Integer[] arrays) {
        Integer[] changedArrays = new Integer[arrays.length];
        int pivot = 2 + new Random().nextInt(arrays.length / 2);
        System.arraycopy(arrays, pivot, changedArrays, 0, arrays.length - pivot);
        System.arraycopy(arrays, 0, changedArrays, arrays.length - pivot, pivot);
        return changedArrays;
    }
}
