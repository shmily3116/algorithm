package search;

public class BinarySearch extends AbstractSearch{

    @Override
    protected Integer actualSearch(Integer[] arrays, int target) {
        int low = 0, high = arrays.length - 1, mid = (low + high) / 2;
        while (mid != low){
            if (arrays[high] == target){
                return high;
            }
            if (arrays[mid] == target){
                return mid;
            }
            if (arrays[mid] > target){
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2;
        }
        return -1;
    }
}
