package twopointer;

public class ProductOfArray {

    /*
        주어진 배열에서 자신을 제외한 값들의 곱을
        배열로 반환
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] product2 = new int[nums.length];
        int p = 1;
        // Q. 왜 마지막 곱은 제외하는가? 자신을 제외하는게 배열의 시작은 1넣고 해서인가
        // 왼쪽부터 곱
        for(int i = 0 ; i < nums.length ; i++) {
            product[i] = p;
            p *= nums[i];
        }
        p = 1;
        // 오른쪽 부터 곱
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
            product2[i] = p;
            p *= nums[i];
        }
        // 왼쪽 곱 배열 * 오른쪽 곱 배열
        for(int i = 0 ; i < nums.length ; i++) {
            product[i] *= product2[i];
        }

        return product;
    }

    public static void main(String[] args) {
        for(int i : productExceptSelf(new int[]{-1,1,0,-3,3})) {
            System.out.println(i + ",");
        }
    }

}
