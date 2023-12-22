class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for(int p : prices){
            maxProfit = Math.max(maxProfit, p - minPrice);
            minPrice = Math.min(minPrice, p);
        }
        return maxProfit;
    }
}