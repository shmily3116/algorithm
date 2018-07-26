package leetcode;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {4,2,0,2,3,2,0};
        for (int i=0;i<100;i++){
            System.out.println(Arrays.toString(nums));
            np.nextPermutation(nums);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }
        int leftPos=-1, rightPos = nums.length + 1;
        for (int i=nums.length-1;i>leftPos;i--){
            for (int j=i-1;j>=leftPos && j>=0;j--){
                if (nums[j] < nums[i]){
                    if (j > leftPos) {
                        leftPos = j;
                        rightPos = i;
                    }
                    break;
                }
            }
        }
        if (leftPos >= 0) {
            int tmp = nums[rightPos];
            nums[rightPos] = nums[leftPos];
            nums[leftPos] = tmp;
        }
        Arrays.sort(nums, leftPos + 1, nums.length);
    }
}
