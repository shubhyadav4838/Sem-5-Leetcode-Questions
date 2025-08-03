// Last updated: 4/8/2025, 12:00:24 am
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int[] leftMaxProfit = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            leftMaxProfit[i] = Math.max(leftMaxProfit[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        int maxProfit = 0;
        int profit = 0;
        int maxPrice = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, profit + leftMaxProfit[i]);
            profit = Math.max(profit, maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);

        }

        return maxProfit;
        
    }
}
/*if(prices.length<=1){
            return 0;
        }
        
        int[] leftmaxprofit=new int[prices.length];
        int[] rightmaxprofit=new int[prices.length];
        int leftminprice=prices[0];
        int rightmaxprice=prices[prices.length-1];

        for(int i=1;i<prices.length;i++){
            leftmaxprofit[i]=Math.max(leftmaxprofit[i-1],prices[i]-leftminprice);
            leftminprice=Math.max(leftminprice,prices[i]);
        }

        for(int i=prices.length-2;i>=0;i--){
            rightmaxprofit[i]=Math.max(rightmaxprofit[i+1],rightmaxprice-prices[i]);
            rightmaxprice=Math.max(rightmaxprice,prices[i]);
        }
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            maxprofit=Math.max(maxprofit,leftmaxprofit[i]+rightmaxprofit[i]);
        }
        return maxprofit;*/