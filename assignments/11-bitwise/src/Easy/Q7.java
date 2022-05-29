package Easy;

public class Q7 {
    public int hammingDistance(int x, int y) {
        if (x > y)
            return hammingDistance(y, x);
        // x < y
        int count = 0;
        while (y > 0) {

            if (((x&1) ^ (y&1)) == 1) {
//                System.out.println((x&1)+" XOR "+(y&1));
                count++;
            }

            x >>= 1;
            y >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q7().hammingDistance(1,4));
        System.out.println(new Q7().hammingDistance(3,1));
    }
}

