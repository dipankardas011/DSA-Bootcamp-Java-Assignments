package Medium;

/**
 * Q3
 * https://leetcode.com/problems/number-of-ways-to-split-a-string/discuss/830455/JavaPython-3-Multiplication-of-the-ways-of-1st-and-2nd-cuts-w-explanation-and-analysis.
 */
public class Q3 {
    public int numWays(String s) {
    	int ones = 0;
		final int m = 1_000_000_007;
		int len = s.length();

		for (int i = 0; i<len; i++)
			ones += s.charAt(i) - '0';

		if(ones == 0)
			return (int)((len - 2L)*(len - 1L)/2%m);

		if(ones%3 != 0)
			return 0;

		int noOfOnesInBlock = ones / 3;
		long first=0, second = 0;

		for (int i = 0, count=0; i<len; i++) {
			count += s.charAt(i) - '0';

		if(count == noOfOnesInBlock)
			first++;
		if(count == 2*noOfOnesInBlock)
			second++;
	}

	return (int)(first*second%m);
    }
    public static void main(String[] args) {
		String s="10101";
		Q3 ob = new Q3();
		System.out.println(ob.numWays(s));
	}
}
