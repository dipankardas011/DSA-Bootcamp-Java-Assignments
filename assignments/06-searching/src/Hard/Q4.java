package Hard;

public class Q4 {
    boolean isPossible(int[] arr, int m, int curr_min)
    {
        int studentsRequired = 1;
        int curr_sum = 0;

        for (int j : arr) {
            if (j > curr_min)
                return false;

            if (curr_sum + j > curr_min) {
                studentsRequired++;
// reset the sum
                curr_sum = j;

                if (studentsRequired > m)
                    return false;
            }
            else
                curr_sum += j;
        }
        return true;
    }
    public int findMinimumPagesAllocated(int[] books, int m) {
        int start = 0;// minimum pages
        int end = -1;
        for (int i : books)
            end += i;

        int ans=Integer.MIN_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(isPossible(books,m,mid)) {
                ans = mid;
                end = mid - 1;// as to reduce the mid pages so t oget the min value
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Q4().findMinimumPagesAllocated(new int[]{12, 34, 67, 90}, 2));
    }
}
