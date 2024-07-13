class Solution {
    public int majorityElement(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      if(n==1||n==2)
      return nums[0];
      int m = n/2 + 1;
      return nums[m-1];
    }
}
