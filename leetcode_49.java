//注意备注的语法
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        List<List<String>> result_1 = new ArrayList<>();
        int n = strs.length;
        for (int i=0;i<n;i++){
            char []temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String str = new String(temp); //这个要注意
            if(result.containsKey(str)){
             List<String>temp1 = result.get(str);
             temp1.add(strs[i]);
             result.put(str,temp1);
                continue;
            }
            List<String>temp2 = new ArrayList();
            temp2.add(strs[i]);
            result.put(str,temp2);
        }
          //怎么遍历哈希表的要注意
        for(Map.Entry<String, List<String>>entry:result.entrySet()){
            result_1.add(entry.getValue());
        }
        return result_1;

    }
}
