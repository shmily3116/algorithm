package leetcode;

import java.util.*;
import java.util.stream.Stream;

public class MedianOfTwoArrays {

    private static int count = 0;

    public static void main(String[] args){
        count = 0;
        Random random = new Random();
        int exeCnt = 0, corrCnt = 0;
        while(exeCnt < 10) {
            //System.out.println(Arrays.toString(Stream.generate(() -> random.nextInt(9999)).limit(7).sorted().toArray()));
            Integer[] array1 = Stream.generate(() -> random.nextInt(9999)).limit(random.nextInt(10) + 1).sorted().toArray(Integer[]::new);
            //Integer[] array1 = new Integer[]{1,3};
            //System.out.println(Arrays.toString(array1));
            Integer[] array2 = Stream.generate(() -> random.nextInt(9999)).limit(1).sorted().toArray(Integer[]::new);
            //Integer[] array2 = new Integer[]{2};
            //System.out.println(Arrays.toString(array2));
            List<Integer> list = new ArrayList<>();
            list.addAll(Arrays.asList(array1));
            list.addAll(Arrays.asList(array2));
            Collections.sort(list);
            //System.out.println(list);
            int size = list.size();
            double answer, found = new MedianOfTwoArrays().findMedianSortedArrays(array1, array2);
            if (size % 2 == 0) {
                answer = (list.get(size / 2 - 1) + list.get(size / 2)) * 0.5;
            } else {
                answer = list.get(size / 2);
            }
            if (found != answer) {
                System.out.println("/-------------------------------------------------/");
                System.out.println(list);
                System.out.println("found:" + found + "  <------>  " + "answer:" + answer);
            } else {
                corrCnt++;
            }
            //System.out.println("answer:" + answer);
            //System.out.println(" found:" + found);
            //System.out.println(count);
            //System.out.println(Math.log(list.size()/Math.log(2)));
            exeCnt++;
        }
        System.out.println(corrCnt);
    }

    public double findMedianSortedArrays(Integer[] nums1, Integer[] nums2) {
        if (nums1.length == 1 && nums2.length == 1){
            return (nums1[0] + nums2[0]) * 0.5;
        }
        if (nums1.length < nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        boolean even = (nums1.length + nums2.length) % 2 == 0;
        if (nums2.length == 1){
            if (even){

            } else {

            }
        }
        int gap1 = nums1.length/2, gap2 = nums2.length/2;
        return findMedianSortedArrays(nums1, gap1, nums2, gap2, even);
    }

    public double findMedianSortedArrays(Integer[] nums1, int start1, Integer[] nums2, int start2, boolean even) {
        //System.out.println("start1:"+start1+"  <----->  start2:"+start2);
        count++;
        int gap;
        if (even){
            // 总数为偶数，需要两个数的中值
            gap = (nums1.length + nums2.length) / 2 - (start1 + start2 + 2);
        } else {
            // 总数为奇数，需要中位数
            gap = (nums1.length + nums2.length + 1) / 2 - (start1 + start2 + 2);
        }
        if (gap == 0) {
            if (nums1[start1] < nums2[start2 + 1] && nums2[start2] < nums1[start1 + 1]) {
                if (even) {
                    return (Math.max(nums1[start1], nums2[start2]) + Math.min(nums1[start1 + 1], nums2[start2 + 1])) * 0.5;
                } else {
                    return Math.max(nums1[start1], nums2[start2]);
                }
            } else {
                if (nums1[start1] > nums2[start2]){
                    return findMedianSortedArrays(nums1, start1 - 1, nums2, start2 + 1, even);
                } else {
                    return findMedianSortedArrays(nums1, start1 + 1, nums2, start2 - 1, even);
                }
            }
        } else {
            boolean choose = nums1[start1] > nums2[start2];
            int gap0 = Math.abs(gap / 2) == 0 ? 1 : Math.abs(gap / 2);
            if (gap > 0){
                // 总数不够，需增加
                if (choose) {
                    return findMedianSortedArrays(nums1, start1, nums2, start2 + gap0, even);
                } else {
                    return findMedianSortedArrays(nums1, start1 + gap0, nums2, start2, even);
                }
            } else {
                // 总数过半，需减少
                if (choose) {
                    return findMedianSortedArrays(nums1, start1 - gap0, nums2, start2, even);
                } else {
                    return findMedianSortedArrays(nums1, start1, nums2, start2 - gap0, even);
                }
            }
        }
    }
}

