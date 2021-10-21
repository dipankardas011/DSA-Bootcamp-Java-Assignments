package Easy;

public class Q7 {
    public static int findKthPositive(int[] arr, int k) {
        int start=0;
        int end=arr.length-1;
        while(start <= end)
        {
            int mid = start +(end - start)/2;
            int countmissing = arr[mid]-mid-1;
            if(countmissing < k) {
                start = mid +1;
            }
            else {
                end = mid -1;
            }
        }
        return start+k;
    }

    public static void main(String[] args) {
        if (findKthPositive(new int[]{2,3,4,7,11}, 5) == 9)
            System.out.println("correct");
        else
            System.out.println("wrong");
        if (findKthPositive(new int[]{1,2,3,4}, 2) == 6)
            System.out.println("correct");
        else
            System.out.println("wrong");
    }
}
