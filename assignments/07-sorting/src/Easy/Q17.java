package Easy;

public class Q17 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int j : arr1) {
            count[j]++;
        }
        int iter = 0;
        for (int ele : arr2) {
            while (count[ele]-- > 0) {
                arr1[iter++] = ele;
            }
        }

        for (int n=0; n<count.length; n++) {
            while (count[n]-- > 0) {
                arr1[iter++] = n;
            }
        }
        return arr1;
    }
}
