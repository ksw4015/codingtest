package bst;

/**
 * LeetCode 704
 * 이진검색 기초
 *
 */
public class BinarySearch {

    /*
        재귀를 이용한 이진검색
     */
    public int solution(int[] input) {
        return binarySearch(input, 9, 0, input.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if(left <= right) {
            int mid = left + (right - left) / 2;  // 왼쪽포인터와 오른쪽포인터의 중간지점
            if(nums[mid] < target) {
                return binarySearch(nums, target, mid + 1, right);  // 왼쪽 포인터를 중간 지점으로 이동
            } else if(nums[mid] > target) {
                return binarySearch(nums, target, left, mid - 1);  // 오른쪽포인터를 중간지점으로 이동
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().solution(new int[]{-1,0,3,5,9,12,15}));
    }

}
