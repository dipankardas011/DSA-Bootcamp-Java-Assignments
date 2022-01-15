package Easy;

import java.util.Arrays;

public class Q8 {
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void insertionSortRec(int[] arr, int row, int col) {
        if (row == arr.length)
            return ;

        if (col == 0) {
            insertionSortRec(arr, row+1, row+1);
        }
        if (col > 0) {
            if (arr[col] < arr[col-1]) {
                swap(arr, col, col-1);
            }
            insertionSortRec(arr, row, col-1);
        }
    }

    public static void main(String[] args) {
        Q8 o = new Q8();
        int[] arr = {5,4,3,7,1};
        o.insertionSortRec(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
}
