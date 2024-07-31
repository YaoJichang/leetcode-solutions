//题解中用spilt函数 更简单 值得学习
class Solution {
public boolean wordPattern(String pattern, String s) {
        String[] list  = s.split(" ");
        if (list.length!= pattern.length()) {
            return false;
        }
        HashMap<Character,String> c2s = new HashMap<Character,String>();
        //或者Map<Character,String> c2s = new HashMap<Character,String>();
        HashMap<String,Character> s2c = new HashMap<String,Character>();
        for (int i = 0; i < list.length; i++) {
            if (c2s.containsKey(pattern.charAt(i))) {
                if( !c2s.get(pattern.charAt(i)).equals(list[i])){
                    return false;
                }
            }
            if (s2c.containsKey(list[i])) {
                if( !s2c.get(list[i]).equals(pattern.charAt(i))){
                    return false;
                }
            }

            c2s.put(pattern.charAt(i), list[i]);
            s2c.put(list[i], pattern.charAt(i));
        }
        return true;
    }
}//既要看这个题解用的spilt 也要看看你的提交记录里面的方法（边界处理）
