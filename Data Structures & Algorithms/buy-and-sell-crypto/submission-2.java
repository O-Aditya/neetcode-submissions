class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int min = prices[0];

        for(int i = 1 ; i < n ; i++){
            int cost = prices[i] - min;

            if(cost > profit){
                profit = cost;
            }else if( min > prices[i]){
                min = prices[i];
            }
        }

        return profit;
    }
}
