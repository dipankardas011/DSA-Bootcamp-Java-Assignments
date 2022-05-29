package Hard;

public class Q4 {
    /**
     * OPTIMIZATION can be made like memoization
     * @param N
     * @return
     */
    public boolean isTT( int N) {
        if (N <= 10) {
            return N == 1 || N == 7 || N == 10;
        }
        int newN = 0;
        while (N > 0) {
            int d = N%10;
            newN += d*d;
            N /= 10;
        }
        return isTT(newN);
    }

    public int nextHappy(int N){
        int checkNumber = N + 1;
        while (true) {
            if (isTT(checkNumber))
                return checkNumber;
            checkNumber++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q4().nextHappy(10));
    }
}
