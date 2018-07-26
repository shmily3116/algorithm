package search;

import java.util.Random;

public class ModBinarySearch extends AbstractSearch {

    @Override
    protected Integer actualSearch(Integer[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target ? 0:-1;
        }
        int low = 0, high = nums.length - 1, mid = (low + high) / 2;
        while (true){
            if (nums[low] == target){
                return low;
            }
            if (nums[mid] == target){
                return mid;
            }
            if (nums[high] == target){
                return high;
            }
            if (mid == low || mid == high){
                break;
            }
            if (nums[mid] < target){
                if (nums[low] > nums[mid]){
                    // pivot before mid
                    if (nums[high] > target) {
                        low = mid;
                    } else {
                        high = mid;
                    }
                }else {
                    // pivot after mid
                    low = mid;
                }
            } else {
                if (nums[mid] > nums[low]){
                    // pivot after mid
                    if (target > nums[low]){
                        high = mid;
                    } else {
                        low = mid;
                    }
                } else {
                    // pivot before mid
                    high = mid;
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

    public static void main(String[] args) {
        Integer[] nums = {1,3,5};
        System.out.println(new ModBinarySearch().actualSearch(nums, 1));
    }
}
