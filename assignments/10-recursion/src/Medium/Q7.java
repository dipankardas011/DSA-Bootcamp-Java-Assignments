package Medium;

import java.util.ArrayList;

public class Q7 {
    /**
     * @param list
     * @param nextBegin
     * @param N
     * @param currNum
     */
    private void utility(ArrayList<Integer> list, int nextBegin, int N, int currNum) {
        if (N == 0) {
            list.add(currNum);
            return;
        }

        for (int i = nextBegin; i <= 9; i++) {
            int newNum = currNum*10 + i;
            utility(list, i+1, N-1, newNum);
        }
    }

    public ArrayList<Integer> increasingNumbers(int num){
        ArrayList<Integer> o = new ArrayList<>();

        if (num == 1)
        {
            for (int i = 0; i <= 9; i++)
                o.add(i);
            return o;
        }

        utility(o, 1, num, 0);
        return o;
    }

    public static void main(String[] args) {
        Q7 obj = new Q7();
        System.out.println(obj.increasingNumbers(2));
    }
}
