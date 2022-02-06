package Easy;

import java.util.Arrays;

public class Q7 {
    /**
     * 1 2 3 4 5
     * 1 2 3 4
     * 1 2 3
     * 1 2
     * 1
     *
     */
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void bubbleSortRec(int[] arr, int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            if (arr[col] > arr[col+1])
                swap(arr, col, col+1);
            bubbleSortRec(arr, row, col+1);
        } else {
            bubbleSortRec(arr, row-1, 0);
        }
    }



    public static void main(String[] args) {
        int[] ar = new int[]{5,2,4,2,7,1};

        new Q7().bubbleSortRec(ar, ar.length-1, 0);

        System.out.println(Arrays.toString(ar));
    }
}
