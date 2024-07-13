//还可以关注一下O(1)空间复杂度的方法 然后你真的要调换一下你的 正序思维了！
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] nums_ji = new int[n];
        int [] pre_ji = new int [n];
        int [] suf_ji = new int [n];
       pre_ji[0] =1;
       suf_ji[n-1] = 1;
        for (int i =1;i<n;i++){
            pre_ji[i] = pre_ji[i-1] *nums[i-1];
        }
        for (int j = n-2;j>=0;j--){
            suf_ji[j] = suf_ji[j+1] *nums[j+1];
        }

        for (int i =0;i<n;i++)
        nums_ji[i] = pre_ji[i] * suf_ji[i];
        return nums_ji;
    }
}
