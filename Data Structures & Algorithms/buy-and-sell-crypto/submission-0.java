class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int output = 0;

        for(int i = 0; i < prices.length; i++){
            
            int profit = prices[i] - min;
            min = Math.min(min, prices[i]);
            output = Math.max(profit, output);
        }

        return output;
    }
}
