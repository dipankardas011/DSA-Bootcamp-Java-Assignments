package Easy;

public class Q14 {
    public int countSetBits(int N) {
        int count = 0;
        while (N > 0) {
            count += (N&1);
            N >>= 1;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        // use the bubble sort to sort
        bubble(arr, arr.length-1, 0);
        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    void bubble(int[] arr, int row, int col) {

        if (row == 0){
            return;
        }

        if (col<row) {
            int ii = countSetBits(arr[col]);
            int jj = countSetBits(arr[col+1]);
            // sort
            if ( ii > jj) {
                swap(arr, col, col+1);
            } else {
                if (ii == jj) {
                    //ascending sort it
                    if (arr[col] > arr[col+1])
                        swap(arr, col, col+1);
                }
            }

            bubble(arr, row, col+1);
        } else {
            bubble(arr, row-1, 0);
        }
    }
}
