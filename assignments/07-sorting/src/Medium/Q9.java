package Medium;
import java.util.*;

public class Q9 {

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for (int i=0; i<nums.length; i++)
            ans[i] = String.valueOf(nums[i]);
        Arrays.sort(ans, new LargerNumberComparator());

        if (ans[0].equals("0"))
            return ans[0];

        StringBuilder res = new StringBuilder();

        for (String i : ans) {
            res.append(i);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Q9 o =new Q9();
        System.out.println(o.largestNumber(new int[]{3,30,34,5,9}));
    }
}
