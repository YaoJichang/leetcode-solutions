class Solution {
    public int maxProfit(int[] prices) { //关键就是找到单调性由递增变为递减的那一天
    // 然后学习一下Math.max的用法！
        int start_flag =0;
        int end_flag = 1;
        int max_count = 0;
        int max_count_temp = 0;
        int n = prices.length;
        if (n == 1)
        return 0;
        while(end_flag<n){
            if (prices[start_flag]<=prices[end_flag]){
                max_count_temp = prices[end_flag] - prices[start_flag];
              /*  if (max_count_temp>max_count){
                    max_count = max_count_temp;
                }*/
                max_count = Math.max (max_count,max_count_temp);
                end_flag ++ ;
            }
            else{
                start_flag = end_flag;
                end_flag ++;
                max_count_temp = 0;

            }
        }
 return max_count;
    }
}
