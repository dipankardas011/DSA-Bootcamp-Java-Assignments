package Medium;
import java.util.*;

public class Q6 {
    public void sortColors(int[] A) {
        int second=A.length-1, zero=0;
        for (int i=0; i<=second; i++) {
            while (A[i]==2 && i<second) swap(A, i, second--);
            while (A[i]==0 && i>zero) swap(A, i, zero++);
        }
    }


    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        new Q6().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

}
