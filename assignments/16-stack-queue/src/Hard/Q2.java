package Hard;

import java.util.*;

public class Q2 {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        Deque<Integer> store= new ArrayDeque<>();
//        ArrayList<Integer> list= new ArrayList<>();
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < k; i++) {
//            store.addLast(nums[i]);
//            max = Math.max(max, nums[i]);
//        }
//        list.add(max);
//
//        for (int i = k; i < nums.length; i++) {
//            if (store.getFirst() == max) {
//                // again calculate
//                store.pollFirst();
//                store.addLast(nums[i]);
//                max = Integer.MIN_VALUE;
//                for (Integer x : store) {
//                    max = Math.max(max, x);
//                }
//            } else {
//                store.pollFirst();
//                store.addLast(nums[i]);
//                max = Math.max(max, store.getLast());
//            }
//            list.add(max);
//
//        }
//
//        int[] ans = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ans[i] = list.get(i);
//        }
//
//        return ans;
//    }
    public int[] maxSlidingWindow(int[] a, int k) {

        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q2().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(new Q2().maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}
