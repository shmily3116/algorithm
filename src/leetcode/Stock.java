package leetcode;

public class Stock {
    public int maxProfitI(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int max = 0, curMax = prices[0], curMin = prices[0];
        for (int i=1;i<prices.length;i++){
           if (prices[i] > curMax){
               curMax = prices[i];
               if (curMax - curMin > max){
                   max = curMax - curMin;
               }
           }
           if (prices[i] < curMin){
               curMin = curMax = prices[i];
           }
        }
        return max;
    }

    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int max = 0;
        for (int i=1;i<prices.length;i++){
            if (prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
