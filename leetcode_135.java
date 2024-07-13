//方法抄的题解（你想了两天 真的学习到了！）
//还有种类似的思路：通过向前遍历，确定每个下降序列的结束位置，并记录在mark数组中。
//接着，通过向后遍历，确定每个上升序列的开始位置，并计算每个元素所需的糖果数量 最后再加起来

//官方题解的第二种方法与你的想法比较像 但是有关键点你没想到 你也要去看看

//这在leetcode上是一道困难的题目，其难点就在于贪心的策略，如果在考虑局部的时候想两边兼顾，就会顾此失彼。

//那么本题我采用了两次贪心的策略：

//一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
//一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
//这样从局部最优推出了全局最优，即：相邻的孩子中，评分高的孩子获得更多的糖果。


class Solution {
    /**
         分两个阶段
         1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
         2、起点下标 ratings.length - 2 从右往左， 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大） 和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
    */
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        for (int i = 1; i < len; i++) {
            candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }

        int ans = 0;
        for (int num : candyVec) {
            ans += num;
        }
        return ans;
    }
}
