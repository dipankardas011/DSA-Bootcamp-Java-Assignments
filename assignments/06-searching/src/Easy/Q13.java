package Easy;

import java.util.Arrays;

public class Q13 {
    public boolean checkIfExist(int[] arr) {
        for (int i =0 ;i<arr.length; i++) {
            int t = 2*arr[i];
            for(int j =0 ;j<arr.length; j++) {
                if(j!=i && arr[j]==t)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {-2,0,10,-19,4,6,-8};
        Q13 o = new Q13();
        System.out.println((o.checkIfExist(a)));
    }
}
