package leetcode;

import java.util.Arrays;

/**
 * @author daojia
 * @date 2018-9-13.
 */
public class Stock {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 6, 8};
        Stock stock = new Stock();
        System.out.println(stock.maxProfitIII(arr));
        System.out.println(stock.maxProfitDP(arr, 2));
    }

    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int[] maxP = maxProfit(prices), maxPI = minProfit(prices);
        int max = 0;
        for (int i=0;i<prices.length;i++){
            if (maxP[i] + maxPI[i] > max){
                max = maxP[i] + maxPI[i];
            }
        }
        return max;
    }

    public int[] maxProfit(int[] prices) {
        int max = 0, curMin = prices[0];
        int[] maxP = new int[prices.length];
        for (int i=1;i<prices.length;i++){
            if (prices[i] - curMin > max){
                max = prices[i] - curMin;
            }
            if (prices[i] < curMin){
                curMin = prices[i];
            }
            maxP[i] = max;
        }
        //System.out.println(Arrays.toString(maxP));
        return maxP;
    }

    public int[] minProfit(int[] prices) {
        int min = 0, curMax = prices[prices.length - 1];
        int[] maxP = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] - curMax < min){
                min = prices[i] - curMax;
            }
            if (prices[i] > curMax){
                curMax = prices[i];
            }
            maxP[i] = -min;
        }
        //System.out.println(Arrays.toString(maxP));
        return maxP;
    }

    public int maxProfitDP(int[] prices, int K){
        int[][] profit = new int[K][prices.length];
        int curMax = 0, curMin = prices[0];
        for (int i = 1; i < prices.length; i++){
            profit[0][i] = Math.max(profit[0][i-1], prices[i] - curMin);
            if (prices[i] < curMin){
                curMin = prices[i];
            }
            for (int k = 1; k < K; k++) {
                for (int j = 1; j < i; j++) {
                    curMax = Math.max(curMax, profit[k-1][j] + prices[i] - prices[j]);
                }
                profit[k][i] = curMax;
            }
        }
        System.out.println(Arrays.toString(profit[0]));
        System.out.println(Arrays.toString(profit[1]));
        return profit[K - 1][prices.length - 1];
    }
}
