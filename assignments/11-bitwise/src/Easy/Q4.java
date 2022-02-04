package Easy;

public class Q4 {
    public static int hammingWeight(int n) {
        //00000000000000000000000010000000
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n&1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
