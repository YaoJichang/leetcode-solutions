//这个解法用的ai的 只移动较短的那一边 时间复杂度为O(n)
//难点是想到用双指针 以及为什么只要移动短的那一边就能得到最优解（看看题解和评论区的分析）
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        
        while (i < j) {
            int currentArea = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, currentArea);
            
            // 移动较短的一边
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return max;
    }
}
