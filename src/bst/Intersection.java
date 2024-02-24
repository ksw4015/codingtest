package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * leetCode 349
 *
 * 교집합찾기
 */
public class Intersection {

    // 브루트포스
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> results = new HashSet<>();
        for (int item : nums1) {
            for (int value : nums2) {
                if (value == item) {
                    results.add(item);
                    break;
                }
            }
        }
        return results.stream().mapToInt(i -> i).toArray();
    }

    // 하나의 배열 우선 정렬 후 이진검색으로 찾기
    public int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> results = new ArrayList<>();
        Arrays.sort(nums1); // 오름차순 기본 정렬
        for(int i = 0 ; i < nums1.length ; i++) {
            if(binarySearch(nums2, nums1[i], 0, nums2.length - 1) != -1) {
                results.add(nums1[i]);
            }
        }
        return results.stream().mapToInt(i -> i).toArray();
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if(left <= right) {
            int mid = left + (right - left) / 2;
            if(target < nums[mid]) {
                return binarySearch(nums, target, left, mid - 1);
            } else if (target > nums[mid]) {
                return binarySearch(nums, target, mid + 1, right);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        new Intersection().intersection2(new int[]{4,9,5}, new int[]{9,4,9,8,4});
    }

}
