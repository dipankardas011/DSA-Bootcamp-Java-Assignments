package Week1;

public class sales {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int[] maxFromRight = new int[prices.length];

        maxFromRight[prices.length - 1] = prices[prices.length - 1];

        for (int k = prices.length-2; k>=0 ;k--)
            maxFromRight[k] = Math.max(prices[k], maxFromRight[k+1]);


        for (int i = 1; i<prices.length; i++) {
            int profit = ((maxFromRight[i] - prices[i-1]) >= 0) ? maxFromRight[i] - prices[i-1] : 0;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
}
