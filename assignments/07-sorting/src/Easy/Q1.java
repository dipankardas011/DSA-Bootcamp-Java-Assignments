package Easy;

import java.util.Arrays;

public class Q1 {
    public void merge(int[] a1, int m, int[] a2, int n) {
        int[] temp = new int[m+n];
        int i=0;
        int j=0;
        int pos = 0;
        while (i<m && j<n) {
            if (a1[i] < a2[j]) {
                temp[pos++] = a1[i];
                i++;
            } else if (a1[i] > a2[j]) {
                temp[pos++] = a2[j];
                j++;
            } else {
                temp[pos++] = a1[i];
                temp[pos++] = a2[j];
                i++;
                j++;
            }
        }
        while (i<m) {
            temp[pos++] = a1[i];
            i++;
        }
        while (j<n) {
            temp[pos++] = a2[j];
            j++;
        }

        for (i = 0; i<a1.length;i++){
            a1[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1,2,3,0,0,0};
        int[] n2 = new int[]{2,5,6};
        Q1 o = new Q1();
        o.merge(n1,3,n2,n2.length);
        System.out.println(Arrays.toString(n1));
    }
}
