package bst;

import java.util.Arrays;

/**
 * Leetcode 240
 * 2차원 배열에서 Target 숫자가 있는지 판별
 */
public class SearchMatrix {

    /*
        이진검색 이용
        제출하면 풀리긴한다 (타임아웃 안남)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (Arrays.binarySearch(ints, target) >= 0) {
                return true;
            }
        }
        return false;
    }

    /*
        첫행의 끝 숫자를 타겟 숫자와 비교해서
        크면 col을 왼쪽으로 이동 작으면 row를 아래로 이동 (col--, row++)
        숫자가 왼쪽에서 오른쪽으로 위에서 아래로 오름차순 정렬이라 통하는 방법
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = 0; // 첫행부터 시작
        int col = matrix[0].length - 1;  // 행의 마지막 열부터 시작
        while (row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                col--; // 열을 왼쪽으로 이동
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchMatrix T = new SearchMatrix();
        int[][] matrix = new int[][] {
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
        };
        System.out.println(T.searchMatrix(matrix, 5));
        System.out.println(T.searchMatrix2(matrix, 5));
    }

}
