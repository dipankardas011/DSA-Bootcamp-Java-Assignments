package Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Q29 {

    public void findAllPerSum(ArrayList<Integer> num, int start,int noOfiter, int targetSum, ArrayList<Integer> temp) {

        if (temp.size() > noOfiter || targetSum < 0)
            return;

        if (targetSum == 0 && temp.size() == noOfiter) {
            System.out.println(temp);
        }

        for (int i = start; i < num.size(); i++) {
            temp.add(num.get(i));
            findAllPerSum(num, i+1, noOfiter, targetSum - num.get(i),temp);
            temp.remove(temp.size()-1);
        }
    }

    public void sieve(int P, int n, int S, boolean[] primes) {
        Arrays.fill(primes, true);

        for (int i = 2; i*i <= S; i++) {
            if (primes[i]) {
                for (int j = i*2; j <= S; j+=i) {
                    primes[j] = false;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = P; i <= S; i++)
            if (primes[i])
                list.add(i);

        findAllPerSum(list,0, n, S, new ArrayList<>());
        System.out.println();
    }

    public static void main(String[] args) {
        Q29 o = new Q29();
        int p=2;
        int S = 23;
        int n = 3;
//        N = 3, P = 2, S = 23
//        primes <S & >p
        o.sieve(p+1, n, S,new boolean[S+1]);
//        N = 4, P = 3, S = 54
        n = 4;
        p=3;
        S=54;
        o.sieve(p+1, n, S,new boolean[S+1]);
    }
}