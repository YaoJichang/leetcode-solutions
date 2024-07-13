//你写的太辣眼睛了，还是看GPT的吧 这道题就是小狗咪神操作的那道题哦
class Solution {
    public boolean canJump(int[] nums) {
        int max_pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max_pos) {
                return false;  // 如果当前索引超过了可以到达的最远位置，则无法到达最后一个位置
            }
            max_pos = Math.max(max_pos, i + nums[i]);  // 更新可以到达的最远位置
        }
        return true;  // 如果循环结束且没有返回 false，说明可以到达最后一个位置
    }
}
