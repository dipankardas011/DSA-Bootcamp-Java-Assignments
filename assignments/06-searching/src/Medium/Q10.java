package Medium;

public class Q10 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1000000000;
        while (l < r) {
            int m = (l + r) / 2, total = 0;
            for (int p : piles)
                total += (int)Math.ceil((double)p/(double)m);
            if (total > h)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        Q10 o = new Q10();

        System.out.println(o.minEatingSpeed(new int[]{3,6,7,11},8));
        System.out.println(o.minEatingSpeed(new int[]{30,11,23,4,20},5));
    }
}
