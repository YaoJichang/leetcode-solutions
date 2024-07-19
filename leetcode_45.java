class Solution {
    public int jump(int[] nums) { 
        int max_pos = 0;
        int step = 0;
        int flag = 0;
        if (nums.length==1)
        return 0;
        for (int i = 0; i < nums.length; i++) {      
            if (nums[i]+i>max_pos){
                max_pos = nums[i]+i;
            }
            if (i>=flag){
                    step++;
                    flag = max_pos;
                    if (max_pos>=nums.length-1)
                     break;
                }   
        }
      return step;
    }
}
