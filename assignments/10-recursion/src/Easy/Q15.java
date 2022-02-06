package Easy;

public class Q15 {
    public boolean isSorted(int[] arr, int i) {
        if (arr.length <=1) {
            return true;
        }

        if (i == arr.length) {
            return true;
        }

        if (arr[i] < arr[i-1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static void main(String[] args) {
        System.out.println(new Q15().isSorted(new int[]{1,2,6,4,5}, 1));
    }
}
