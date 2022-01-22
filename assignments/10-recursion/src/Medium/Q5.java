package Medium;

public class Q5 {
    /**
     * The L_th number in row N-1 will generate 2 numbers in row N at position 2L and 2L+1
     * Note the pattern given in the problem 0 -> 01, 1->10.
     * This means the first digit will always stay the same, and the second digit will flip between 0 and 1
     * Now looking backward, our K could be 2L or 2L+1
     * If K is 2L, we know it'll take the same value as L in row N-1.
     * If K is 2L+1, it'll take the flipped value
     * keep doing this x times until we hit the initial value of 0 in row 1.
     * During this x times of recursion, say there are y times where K is odd. Those are the times when the value flipped between 0 and 1
     * so the end result is the initial value 0, flipped y times
     * Now going from K (2L or 2L+1) to L, is really just right shifting K by 1 bit
     * Before you shift, check if the least significant bit of K is 1, if so, record one occurrence of an odd number
     * essentially this is the same as counting the number of 1's in K's binary representation
     */
    public int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;
        return (k - 1 + kthGrammar(n-1,(k+1) >> 1))%2;
    }

    public static void main(String[] args) {
        Q5 o= new Q5();
        System.out.println(o.kthGrammar(2,2));
    }
}
