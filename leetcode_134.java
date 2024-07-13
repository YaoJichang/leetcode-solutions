// 关键：暴力+剪枝 (题解里面还有一个观察函数图像的方法也很巧妙）
//一句话概括：如果x到达不了y+1，那么x-y之间的点也不可能到达y+1，因为中间任何一点的油都是拥有前面的余量的，所以下次遍历直接从y+1开始
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gas_sum = 0;
        int n = gas.length;
        int flag = 0;
        int[] gas_1 = new int[2*n];
        int[] cost_1 = new int[2*n];
        for (int i=0;i<n;i++){
            gas_1[i] = gas [i];
        }
        for(int i = n;i<2*n;i++){
            gas_1[i] = gas[i-n];
        }
        for (int i=0;i<n;i++){
            cost_1[i] = cost [i];
        }
        for(int i =n;i<2*n;i++){
            cost_1[i] = cost[i-n];
        }
        int pos =0;
        while(pos<n){
            gas_sum = gas[pos];
            for (int j = pos+1;j<2*n;j++){ 
                if (gas_sum>=cost_1[j-1]){
                gas_sum = gas_sum - cost_1[j-1]+ gas_1[j];
                flag ++;
                if (flag == n)
               return pos;
            }  else{
                flag = 0;
                pos = j;
                break;
            }           
            }           
        }     
       return -1;
    }
}
