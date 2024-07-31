//只需要magazine中字符个数大于等于ransomNote的即可
//用的hashmap 代码很多ai帮忙写的
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         Map <Character,Integer> ransMap = new HashMap<>();
         Map <Character,Integer> magMap = new HashMap<>();
         for(int i=0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            if(ransMap.containsKey(ch)){
               // 如果 ransMap 包含该字符，则获取当前值并加一
               int count = ransMap.get(ch);
               ransMap.put(ch, count + 1);
            }
            else {
                // 如果 ransMap 不包含该字符，将其加入并设置值为1
                  ransMap.put(ch, 1);
                  }
         }

       for(int i=0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            if(magMap.containsKey(ch)){
               // 如果 magMap 包含该字符，则获取当前值并加一
               int count = magMap.get(ch);
               magMap.put(ch, count + 1);
            }
            else {
                // 如果 magMap 不包含该字符，将其加入并设置值为1
                  magMap.put(ch, 1);
                  }
         }

         for (char key:ransMap.keySet()){
           // if(ransMap.get(key)>magMap.get(key)){
             if(ransMap.get(key)>magMap.getOrDefault(key,0)){
                return false;
            }
         }
         return true;
    }
}
