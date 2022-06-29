public class Q1 {
    public static void findPair(int[] A) {
        int i=0,j=0;
        int left=0,right=A.length-1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = A[left] + A[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                i=left;
                j=right;
            }

            if (sum == 0)
                break;

            if (sum < 0)
                left++;
            else
                right--;
        }
        System.out.println(A[i]+", "+A[j]);
    }

    public static void main(String[] args) {
        findPair(new int[]{-6, -5, -3, 0, 2, 4, 9});
    }
}
