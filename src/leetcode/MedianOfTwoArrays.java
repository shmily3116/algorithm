package leetcode;

public class MedianOfTwoArrays {

    public double findMedianSortedArrays(Integer[] nums1, Integer[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m=nums1.length, n=nums2.length, imin=0, imax=m;
        int i, j, half=(m+n+1)/2;
        double maxLeft, minRight;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = half - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m+n)%2 == 1){
                    return maxLeft;
                }
                if (i==m){
                    minRight=nums2[j];
                } else if (j==n){
                    minRight=nums1[i];
                } else {
                    minRight=Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight)/2;
            }
        }
        return 0D;
    }
}