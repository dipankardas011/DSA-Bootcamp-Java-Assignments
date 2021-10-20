package Easy;


class GuessGame {
    private int pick;
    public int guess(int num) {
        if (pick < num)
            return -1;
        if (pick == num)
            return 0;
        //(pick > num)
            return 1;
    }

    protected void insertPick(int pick) {
        this.pick = pick;
    }
}

public class Q1 extends GuessGame {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    public int guessNumber(int num) {
        int start = 1;
        int end = num;
        while (start <= end ) {
            int mid = start + (end - start) / 2;
            switch (guess(mid)) {
                case -1 -> end = mid - 1;
                case 0 -> {return mid;}
                case 1 -> start = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Q1 ob = new Q1();
        int pick = 6;
        int N = 10;
        ob.insertPick(pick);
        System.out.println(ob.guessNumber(N));
    }
}