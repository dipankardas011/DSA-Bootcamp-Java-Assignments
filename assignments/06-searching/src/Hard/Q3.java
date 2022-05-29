/**
 * @question
 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
 *
 * His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 * Input
 * t – the number of test cases, then t test cases follows.
 * * Line 1: Two space-separated integers: N and C
 * * Lines 2..N+1: Line i+1 contains an integer stall location, xi
 * Output
 * For each test case output one integer: the largest minimum distance.
 * Example
 * Input:
 *
 * 1
 * 5 3
 * 1
 * 2
 * 8
 * 4
 * 9
 * Output:
 *
 * 3
 * Output details:
 *
 * FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
 * resulting in a minimum distance of 3.
 * @hint
 * If you didn't understand the problem: you gotta maximize the distance between
 * every (adjacent) cow and then finally choose the one which has the minimum value.
 * Example: say you have 3 apples and 10 places to put them ( 1,2,3,4,5,6,7,8,9,10).
 * If you place on 1,3,10 then distance between 1,3 is 2 whereas 3,10 is 7, but this
 * case is not optimal. If you place on 1,5,10 then distance between 1,5 is 4 and
 * 5,10 is 5, this is the max you can get between them simultaneously. Hence,
 * you choose 4 as the ans because this is minimum after maximizing.
 */

package Hard;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {

    public boolean CheckPlaces(int[] stalls, int midStall,int c, int n) {
        int noOfCows = 1;
        int placed = stalls[0];

        for (int i=0 ;i<n; i++) {
            if (stalls[i] - placed >= midStall) { // the distance b/w the 2 cows are >= midStall value passed
                placed = stalls[i];
                noOfCows++;
            }
            if (noOfCows == c)
                return true;
        }
        return false;
    }

    public int binarySearch(int[] stalls, int c, int n) {
        Arrays.sort(stalls);
        int start = stalls[0];
        int end = stalls[stalls.length-1];

        int ans = -1;//minDistance

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(CheckPlaces(stalls,mid, c,n)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int N, C;
            N = in.nextInt();
            C = in.nextInt();

            int[] stalls = new int[N];
            for (int i = 0; i < N; i++) {
                stalls[i] = in.nextInt();
            }
            int ans = new Q3().binarySearch(stalls,C,N);
//            1
//            5 3
//            1 2 8 4 9

            System.out.println(ans);
        }
    }
}
