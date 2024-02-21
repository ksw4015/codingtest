package sort;

/**
 * 버블정렬
 * 외우자
 * 시간복잡도
 */
public class BubbleSort {
    public int[] bubbleSort(int[] arr) {
        for(int i = 1 ; i < arr.length ; i++) {
            for(int j = 0 ; j < arr.length - 1 ; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
}
