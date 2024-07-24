//GPT优化版
//优化的地方：跳过重复元素：在检测到 nums[start] 或 nums[end] 相同的情况下，通过 while 循环跳过这些重复元素，这样可以避免重复的三元组。
//减少重复检查：避免在每次找到一组三元组时都检查 result.contains(subList)，而是直接添加到结果中，通过跳过重复元素来确保没有重复的三元组。

//核心思路：数之和转化为两数之和 用双指针左右算数 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复的元素
            if (nums[i] > 0) break; // 跳过大于0的数
            int target = -nums[i];
            twoSum(nums, i + 1, len - 1, target, result);
        }
        return result;
    }

    private void twoSum(int[] nums, int start, int end, int sum, List<List<Integer>> result) {
        while (start < end) {
            int currentSum = nums[start] + nums[end];
            if (currentSum == sum) {
                result.add(Arrays.asList(-sum, nums[start], nums[end]));
                // 跳过相同的元素
                while (start < end && nums[start] == nums[start + 1]) start++;
                while (start < end && nums[end] == nums[end - 1]) end--;
                start++;
                end--;
            } else if (currentSum < sum) {
                start++;
            } else {
                end--;
            }
        }
    }
}
