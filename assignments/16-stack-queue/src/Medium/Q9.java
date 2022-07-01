package Medium;

public class Q9 {
    int tour(int[] petrol, int[] distance) {
        int start = 0;
        int lackAmount = 0;
        int balance = 0;
        for(int i=0; i<distance.length; i++){
            balance += petrol[i] - distance[i];
            if(balance<0){
                //if not possible now, then add this balance to lackAmount to,
                //check at the end, and make the balance zero,
                //increasing start by one for hoping that maybe balance will be positive in next iteration
                lackAmount += balance;
                start = i+1;
                balance = 0;
            }
        }
        /**
         * we got the balance moving forward and so we need to add the left side balance from
         * 0, start-1 =>> lackamount if adding it petrol left >= 0 then that start is correct
         */
        if(balance+lackAmount >= 0){
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q9().tour(new int[]{4, 6, 7, 4}, new int[]{6, 5, 3, 5})); // 1
    }
}
