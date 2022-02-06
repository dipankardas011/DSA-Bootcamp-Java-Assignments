package Easy;

public class Q14 {
    public int factorial(int n) {
        // Write your code here
        if (n <= 2)
            return n;

        return n*factorial(n-1);
    }
}
