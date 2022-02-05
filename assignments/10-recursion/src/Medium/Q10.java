package Medium;

public class Q10 {
//    using Catalan Numbers
    public int count(int N){
        if (N == 0)
            return 1;

        int res = 0;
        for (int i = 0; i < N; i+=2) {
            System.out.println(i+" "+(N-2-i));
            res += count(i)*count(N-2-i);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Q10().count(2));
//        System.out.println(new Q10().count(4));
        System.out.println(new Q10().count(6));
    }
}
