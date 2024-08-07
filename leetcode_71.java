//这道题有点难读懂 可以看看评论区谭光志的评论
//Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。Deque堆栈操作方法：push()、pop()、peek()。自己再学学怎么用吧 作为双向队列用法有pollLast offerLast addFirst等等 你查查咯
class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast(); // 等价于pop
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name); //等价于push
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst()); //用双向队列能方便得直接从开头拿（栈的话还得逆序）
                //ans.insert(0, stack.pop()).insert(0, '/');
            }
        }
        return ans.toString();
    }
}
