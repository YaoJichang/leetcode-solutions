//抄的题解 这种解法
class Solution {
    public String reverseWords(String s) {
        // 使用StringBuffer来构建结果字符串
        StringBuffer sb = new StringBuffer();
        
        // 首先反转整个字符串【这个reverse函数记住了！（String类型是不可变的 因此要先用StringBuffer）】
        s = new StringBuilder(s).reverse().toString();
        
        // 反转每个单词【这个split也很强 记住！】
        String[] words = s.split(" ");
        for (String word : words) {
            if (!word.isEmpty()) { // 忽略空字符串
                sb.append(new StringBuilder(word).reverse().toString()).append(" ");
            }
        }
        
        // 删除最后一个多余的空格
        return sb.toString().trim();
    }
}
