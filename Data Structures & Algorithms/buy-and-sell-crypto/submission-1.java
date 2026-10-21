class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int output = 0;

        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            output = Math.max(prices[i] - min, output);
        }

        return output;
    }
}
