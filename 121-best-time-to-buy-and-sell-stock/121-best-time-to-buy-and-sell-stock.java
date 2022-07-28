// class Solution {
//    public int maxProfit(int[] prices) {
//     int profit = 0;
//     for (int i = 0; i < prices.length; i++) {
//         for (int j = i; j >= 0; j--) {
//             profit = Math.max(profit, prices[i]-prices[j]);
//         }
//     }
//     return profit;
// }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int lowestUntilThisPoint = Integer.MAX_VALUE;
        int maxProfit = -1;
        
        for (int price: prices) {
            if (price < lowestUntilThisPoint) {
                lowestUntilThisPoint = price;
            }
            int profit = price - lowestUntilThisPoint;
            if (profit > maxProfit) 
                maxProfit = profit;
        }
        return Math.max(maxProfit, 0);
    }
}