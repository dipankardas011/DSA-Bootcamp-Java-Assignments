package Medium;

import java.util.Arrays;

public class Q32 {

    private boolean utility(int[] arr,
                            int[] presence,
                            int leftSum, int rightSum,
                            int start,
                            int lenLeft, int lenRight){
        int N = arr.length;

        if ((N & 1) == 1) {
//            If n is even, then sizes of two subsets must be strictly n/2
//            and if n is odd,
//            then size of one subset must be (n-1)/2 and size of other
//            subset must be (n+1)/2.
            if (lenLeft > ((N-1) >> 1)  ||  lenRight > ((N+1) >> 1))
                return false;
//            if (lenLeft == ((N-1) >> 1)  ||  lenRight == ((N+1) >> 1))
//                return true;
        } else {
            if (lenLeft > (N>>1) || lenRight > (N>>1))
                return false;
//            if (lenLeft == (N>>1) || lenRight == (N>>1))
//                return true;
        }

        if (leftSum == rightSum && leftSum != 0)
            return true;

        for (int i = start; i < arr.length; i++) {
            //either the leftone gets it or the right person gets it
            presence[i] = 0;
            if (utility(arr, presence, leftSum + arr[i], rightSum, i+1,lenLeft+1, lenRight))
                return true;
            else{
                presence[i] = 1;
                if (utility(arr, presence, leftSum, rightSum+arr[i], i+1,lenLeft, lenRight+1))
                    return true;
                else {
                    // neither worked
                    presence[i] = 2;
                }
            }
        }
        return false;
    }

    public void tugOfWar(int[] arr) {
        int[] presence = new int[arr.length];
        Arrays.fill(presence, 2);
        // false means present in firstHalf arr
        // true means secondHalf

        // callsome f()
        boolean ii = utility(arr, presence, 0,0,0, 0, 0);
        // f()

        System.out.println(ii);
        System.out.print("first side arr: ");
        for (int i = 0; i < presence.length; i++) {
            if (presence[i] == 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        System.out.print("second side arr: ");
        for (int i = 0; i < presence.length; i++) {
            if (presence[i] == 1) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        new Q32().tugOfWar(arr);
    }
}


class SSSS {
    void TOWUtil(int[] arr, int n, boolean[] curr_elements,
                 int no_of_selected_elements, boolean[] soln,
                 int sum, int curr_sum, int curr_position)
    {
        if (curr_position == n)
            return;


        if ((n / 2 - no_of_selected_elements) > (n - curr_position))
            return;

        TOWUtil(arr, n, curr_elements, no_of_selected_elements, soln, sum,
                curr_sum, curr_position+1);

        no_of_selected_elements++;
        curr_sum = curr_sum + arr[curr_position];

        // backtracking
        curr_elements[curr_position] = true;

        if (no_of_selected_elements == n / 2)
        {
            if (Math.abs(sum / 2 - curr_sum) < min_diff)
            {
                min_diff = Math.abs(sum / 2 -
                        curr_sum);
                for (int i = 0; i < n; i++)
                    soln[i] = curr_elements[i];
            }
        }
        else
        {
            TOWUtil(arr, n, curr_elements, no_of_selected_elements,
                    soln, sum, curr_sum, curr_position + 1);
        }

        curr_elements[curr_position] = false;
    }


    int min_diff;


    void tugOfWar(int arr[])
    {
        int n = arr.length;

        boolean[] curr_elements = new boolean[n];

        boolean[] soln = new boolean[n];

        min_diff = Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
            curr_elements[i] = soln[i] = false;
        }

        TOWUtil(arr, n, curr_elements, 0,
                soln, sum, 0, 0);

        System.out.print("The first subset is: ");
        for (int i = 0; i < n; i++)
        {
            if (soln[i])
                System.out.print(arr[i] + " ");
        }
        System.out.print("\nThe second subset is: ");
        for (int i = 0; i < n; i++)
        {
            if (!soln[i])
                System.out.print(arr[i] + " ");
        }
    }
}