package Easy;

import java.util.Arrays;

public class Q1 {


    private void SumTriangle(int[] arr) {

        if (arr.length < 1)
            return;
        int[] temp = new int[arr.length-1];

        for (int i = 0; i < arr.length - 1; i++)
            temp[i] = arr[i] + arr[ i+1];


        SumTriangle(temp);

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3,4,5};
        new Q1().SumTriangle(ar);
    }
}
