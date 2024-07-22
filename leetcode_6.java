//看了评论区的两种思路：
//这个题包装的很唬人，但是实际就是给s的每一位标记就好了：假设numRows为4，那就是那s每一位的行数就是：1234321234321
//题解里面还有一个找规律的，感觉也是可行的，一次循环长度是2n-2
//ps 我感觉你这种图形化的找规律题目不太擅长 还是要多做一做
//题解的解法三给出了最优解 解法二给出了不用 ArrayList 而用StringBuffer来实现类似的变长二维数组 然后解法一是你卡壳的普通二维数组方法 都值得你好好看看
class Solution {
    public String convert(String s, int numRows) {
         int n = s.length();
         int flag = 0; // 指向第一行
         int up = 0; //1表示向上
         int down =1;//1表示向下
         StringBuffer sb = new StringBuffer(); 
        List<List<String>> result = new ArrayList<>(numRows); // 【重要】！在java中实现类似于变长的二维数组
         
        //如果只有一行 则直接返回
        if (numRows == 1)
        return s;

        // 为每一行创建一个空的ArrayList
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
        }
   
         for (int i =0;i<n;i++){
                result.get(flag).add(String.valueOf(s.charAt(i))); // 这样写不知道有没有问题
                if(down==1){
                    flag++;
                    if (flag == numRows-1){
                        up = 1;
                        down = 0;
                        continue;
                    }
                } 

                if(up ==1){
                    flag -- ;
                    if(flag==0){
                        up = 0;
                        down =1;
                        continue;
                    }
                }
                

            }
         for (List<String> resultRows: result){
            for (int i =0;i<resultRows.size();i++){
                sb.append (resultRows.get(i));
            }
         }
         return sb.toString();
    
         } 
 
    }
