package leetcode;

import java.util.Arrays;

public class FindFirstAndLast {

    public static void main(String[] args) {
        FindFirstAndLast ff = new FindFirstAndLast();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(ff.searchRange(nums, 9)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        if (nums.length == 1){
            if (nums[0] == target){
                return new int[]{0,0};
            } else {
                return new int[]{-1,-1};
            }
        }
        int low=0, high=nums.length-1, mid=(low+high)/2, left=-1, right=-1;
        if (nums[low] > target || nums[high] < target){
            return new int[]{-1,-1};
        }
        if (nums[0] == target){
            left = 0;
        } else {
            while (true) {
                if (nums[low] < target && nums[low + 1] == target) {
                    left = low + 1;
                    break;
                }
                if (low == mid){
                    break;
                }
                if (nums[mid] < target){
                    low = mid;
                } else {
                    high = mid;
                }
                mid = (low + high) / 2;
            }
        }
        low=left > -1 ? left : 0;
        high=nums.length-1;
        mid=(low+high)/2;
        if (nums[high] == target){
            right = high;
        } else {
            while (true) {
                if (nums[high] > target && nums[high-1] == target) {
                    right = high-1;
                    break;
                }
                if (low == mid){
                    break;
                }
                if (nums[mid] > target){
                    high = mid;
                } else {
                    low = mid;
                }
                mid = (low + high) / 2;
            }
        }
        return new int[]{left, right};
    }
}
