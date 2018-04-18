package leetcode;

public class MedianOfTwoArrays {

    public double findMedianSortedArrays1(Integer[] nums1, Integer[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays1(nums2, nums1);
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

    public double findMedianSortedArrays2(Integer[] nums1, Integer[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays2(nums2, nums1);
        }
        int N1 = nums1.length, N2 = nums2.length;
        int lo = 0, hi = 2*N1, half = N1 + N2 + 2;
        while(lo <= hi){
            int mid1 = (lo + hi) / 2;
            // mid1 实际代表了 mid1+1 个元素，因此mid2 共包含 half - (mid1 + 1) 个元素，因此mid2的实际位置值为 half-(mid1+1)-1=N1+N2-mid1
            int mid2 = half - (mid1 + 1) - 1;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == 2 * N1 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = mid2 == 2 * N2 ? Double.MAX_VALUE : nums2[mid2 / 2];
            if (L1 > R2){
                hi = mid1 - 1;
            } else if (L2 > R1){
                lo = mid1 + 1;
            } else {
                return (Math.max(L1, L2) + Math.min(R1, R2)) * 0.5;
            }
        }
        return -1;
    }
}