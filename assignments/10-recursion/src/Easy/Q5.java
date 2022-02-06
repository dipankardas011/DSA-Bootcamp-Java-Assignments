package Easy;

public class Q5 {
    public int fib(int n) {
        if (n<2){
            return n;
        }

        int a= 0;
        int b=1;
        n -=2;
        int t = 0;
        while (n-- >= 0) {
            t = a+b;
            a = b;
            b = t;
        }

        return t;
    }
}
