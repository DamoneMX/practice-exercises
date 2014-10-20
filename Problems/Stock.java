/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 */
public class Stock {

    /*
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     */

    //O(n) solution
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
            
        int maxProfit = 0;
        int currentMin = prices[0];
        
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - currentMin);
            currentMin = Math.min(currentMin, prices[i]);
        }
        
        return maxProfit;
    }

}
