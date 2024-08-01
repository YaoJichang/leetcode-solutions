//这个题可不简单啊
/*三种可能：
1、最终会得到 1。
2、最终会进入循环。
3、值会越来越大，最后接近无穷大*/
//第三种情况是不存在的 可以看题解
//
class Solution {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}
