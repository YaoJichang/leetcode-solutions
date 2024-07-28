//用GPT帮你修正了越界问题 然后这个指明方向的方法有借鉴题解
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flag = new boolean[m][n]; // 默认为 false
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int direction = 0; // 0:向右 1:向下 2:向左 3:向上
        while (result.size() < m * n) {
            if (direction == 0) { // 向右
                if (j < n && !flag[i][j]) {
                    result.add(matrix[i][j]);
                    flag[i][j] = true;
                    j++;
                } else {
                    direction = 1;
                    j--; // 修正越界
                    i++;
                }
            } else if (direction == 1) { // 向下
                if (i < m && !flag[i][j]) {
                    result.add(matrix[i][j]);
                    flag[i][j] = true;
                    i++;
                } else {
                    direction = 2;
                    i--; // 修正越界
                    j--;
                }
            } else if (direction == 2) { // 向左
                if (j >= 0 && !flag[i][j]) {
                    result.add(matrix[i][j]);
                    flag[i][j] = true;
                    j--;
                } else {
                    direction = 3;
                    j++; // 修正越界
                    i--;
                }
            } else if (direction == 3) { // 向上
                if (i >= 0 && !flag[i][j]) {
                    result.add(matrix[i][j]);
                    flag[i][j] = true;
                    i--;
                } else {
                    direction = 0;
                    i++; // 修正越界
                    j++;
                }
            }
        }
        return result;
    }
}
