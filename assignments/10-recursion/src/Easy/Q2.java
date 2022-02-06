package Easy;

public class Q2 {
    public int findMinRec(int A[], int n) {
        if (n == 1) {
            return A[0];
        }

        return Math.min(A[n], findMinRec(A,n-1));
    }

    public int findMaxRec(int A[], int n) {
        if (n == 1) {
            return A[0];
        }
        return Math.max(A[n], findMaxRec(A,n-1));
    }


    public static void main(String[] args) {
        Q2 o = new Q2();
        int[] ar = new int[]{2,3,5,7,1,4};
        System.out.printf("Min: %d Max: %d\n",o.findMinRec(ar, ar.length-1), o.findMaxRec(ar,ar.length-1));
    }
}
