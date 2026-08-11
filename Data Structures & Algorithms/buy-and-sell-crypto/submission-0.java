class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length; i++){
            if(prices[i] > lowestPrice){
                int profit = prices[i] - lowestPrice;
                maxProfit = Math.max(profit, maxProfit);
            }
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }
        return maxProfit;
    }
}