package Week4;
import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return utility(coins, amount, new int[amount]);
    }

    private int utility(int[] coins, int remaining, int[] memory) {
        if (remaining < 0)
            return -1;
        if (remaining == 0)
            return 0;

        if (memory[remaining - 1] != 0)
            return memory[remaining - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = utility(coins, remaining - coin, memory);
            if (res >= 0 && res < min)
                min = 1 + res;
        }

        memory[remaining - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memory[remaining - 1];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11));
        System.out.println(new CoinChange().coinChange(new int[]{186,419,83,408}, 6249));
    }
}
