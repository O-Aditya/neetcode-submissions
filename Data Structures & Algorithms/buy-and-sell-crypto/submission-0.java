class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = 0;
        int sell = 0;
        int max_profit = 0;

        while(sell < n){

            if(prices[buy] > prices[sell]){
                buy = sell;    
            }
            else{

            int profit = prices[sell] - prices[buy];
            max_profit = Math.max(max_profit , profit);

            }
            
            sell++;

        }

        return max_profit;
    }
}
