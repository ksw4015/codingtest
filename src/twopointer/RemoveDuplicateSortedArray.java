package twopointer;

import java.util.HashSet;

/**
 * LeetCode 26
 * Two Pointer Easy
 */
public class RemoveDuplicateSortedArray {

    // 가장 많이 제출된 풀이
    /*
        1. 시작 포인터는 0 (왼쪽, 오른쪽)
        2. 오른쪽 포인터는 반복문으로 증가 (오른쪽으로 1씩 이동)
        3. 왼쪽 포인터와 오른쪽 포인터의 값이 다르면 왼쪽 포인터를 하나 오른쪽으로 옮긴 후 오른쪽 포인터의 값 삽입
     */
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for(int right = 0 ; right < nums.length ; right++){
            if (nums[left] != nums[right]){
                left = left+1;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static int removeDuplicateSortedArray(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        for(int i = 0 ; i < array.length ; i++) {
            if(!set.contains(array[i])) {
                set.add(array[i]);
                array[index] = array[i];
                index++;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateSortedArray(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

}
