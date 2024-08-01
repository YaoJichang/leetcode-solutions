//题解的哈希表更简单简洁
class Solution {
    public int[] twoSum(int[] nums, int target) {
     int n = nums.length;
     int [] nums_sorted = new int[n];
     for(int i=0;i<n;i++)
     nums_sorted[i] = nums[i];
     Arrays.sort(nums_sorted);

     //用双指针
     int left =0;
     int right = n-1;
     while(left<right){
        if(nums_sorted[left]+nums_sorted[right]==target)
        break;
        else if (nums_sorted[left]+nums_sorted[right]>target){
            right--;
        }
          else if (nums_sorted[left]+nums_sorted[right]<target){
            left++;
        }
     }
     int []result = new int[2];
     boolean flag = true;

     for(int i=0;i<n;i++){
        if(nums[i]==nums_sorted[left]&&flag)
        {
            result[0] = i;
            flag = false;}
        if(nums[i]==nums_sorted[right])
        result[1]=i;
     }
     return result;
    }
}
