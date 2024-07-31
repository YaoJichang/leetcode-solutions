//这道题有很多种解法 可以看看评论区
//这些函数怎么调的 要去学习
class Solution {
    public boolean isAnagram(String s, String t) {
       //java中String是不可变的 所以变成char数组再去排序
         char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}
