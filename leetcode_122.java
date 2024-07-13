class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int count =0 ;
        int start_flag = 0;
        int end_flag = 1;
        if (n == 1)
        return 0;
        if (n ==2){
            if (prices[1]-prices[0]>0)
            return prices[1]-prices[0];
            else
            return 0;
        }
        while(end_flag<n){
            if (prices[end_flag]>=prices[end_flag-1]){
                end_flag++;
            }
            else{
                count += prices[end_flag-1] - prices[start_flag];
                start_flag = end_flag;
                end_flag++;
            }
            if (end_flag == n-1&&prices[end_flag]>=prices[end_flag-1]){
                count += prices[end_flag] - prices [start_flag];
            }
        }
          return count;
    }
}
