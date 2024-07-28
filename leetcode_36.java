//题解的更优解（哈希表 只要遍历一次矩阵 值得学习）
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i<9;i++) //逐行检测是否重复
              {
                   Set <Character> set = new HashSet<Character>();
                   for(int j =0;j<9;j++){
                    if(board[i][j]!='.')
                    {
                        boolean isAdded = set.add(board[i][j]);
                    if(!isAdded)
                    return false;

                    }
                   }
              }

        for(int j =0;j<9;j++){   //逐列检测是否重复
            Set <Character> set = new HashSet<Character>();
            for(int i=0;i<9;i++){
                    if(board[i][j]!='.')
                       {
                        boolean isAdded = set.add(board[i][j]);
                    if(!isAdded)
                    return false;

                    }
            }
        }

        if(!(find33(board,0,3,0,3)&&find33(board,3,6,0,3)&&find33(board,6,9,0,3)&&find33(board,0,3,3,6)&&find33(board,3,6,3,6)&&find33(board,6,9,3,6)
        &&find33(board,0,3,6,9)&&find33(board,3,6,6,9)&&find33(board,6,9,6,9)))
        return false;

        return true;

    }

            //九个小矩阵依次去找是否有重复
    public boolean find33 (char[][]board,int starthang,int endhang,int startlie,int endlie){
              Set <Character> set = new HashSet<Character>();
        for(int i = starthang;i<endhang;i++)
        for(int j =startlie;j<endlie;j++){
            if(board[i][j]!='.'){
                boolean isAdded = set.add(board[i][j]);
                if(!isAdded)
                return false;
            }


        }

        return true;
    }
}
