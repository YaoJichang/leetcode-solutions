//找到数组num中相差最小的两个数 分别放到num1(使该数为最大值）和num2（使该数为最小值）数组里面就行【通过排序然后分割实现】
class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int minresult = Integer.MAX_VALUE ; //怎么设置int为最大值值得学习！！！（int没有无穷大，最大值为2,147,483,647）
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]<minresult) //也可以直接用Math.min 更省时
            {
                minresult = nums[i+1]-nums[i];
            }

        }
        return minresult;

    }
}
