//最巧妙的方法：.先把矩阵的元素按照对角线翻转一下，然后再逐行逆序

//次巧妙的方法：找规律 发现四个位置是处于一个循环之中的 用一个temp实现四个位置的交替变换

/*temp=matrix[row][col]
matrix[row][col]=matrix[n−col−1][row]
matrix[n−col−1][row]=matrix[n−row−1][n−col−1]
matrix[n−row−1][n−col−1]=matrix[col][n−row−1]
matrix[col][n−row−1]=temp
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //先将矩阵按对角线翻转一下
        for(int i =0;i<n;i++)
        for(int j = 0;j<=i;j++)
        {   int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }

        //再逐行逆序
        for(int i=0;i<n;i++)
        for(int j=0;j<n/2;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n-j-1];
            matrix[i][n-j-1] = temp;
        }
    
    }
}
