package sort;

public class QuickSort {

    /*
     재귀 및 파티션, 피벗
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int left = low;
        for(int right = low ; right < high ; right++) {
            if(arr[right] < pivot) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
            }
        }
        int tmp = arr[left];
        arr[left] = arr[high];
        arr[high] = tmp;
        return left;
    }

    public int[] quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }

}
