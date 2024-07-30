//原地的解法
/*我的想法 用00 01 10 11四种情况标识当前细胞的情况 其中00和10是死 01和11是活（看最后一位判断这一轮是死还是活 前一位来判断下一轮是死是活）
00:这一轮为死且下一轮也为死
10:这一轮为死但下一轮为活
01:这一轮为活但下一轮为死
11:这一轮为活且下一轮为活*/
//代码是GPT生成的 你只是给了思路（关注它怎么查邻居的 以及用位运算来变换状态）
class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Directions array to find 8 neighbors
        int[] directions = {-1, 0, 1};
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;
                
                // Check all 8 neighbors
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(directions[i] == 0 && directions[j] == 0)) {
                            int r = row + directions[i];
                            int c = col + directions[j];
                            
                            if (r >= 0 && r < rows && c >= 0 && c < cols && (board[r][c] & 1) == 1) {
                                liveNeighbors++;
                            }
                        }
                    }
                }
                
                // Apply the rules of the game by setting the 2nd bit
                if ((board[row][col] & 1) == 1) { // Current cell is live
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[row][col] = board[row][col] & 1; // Mark as dead in the next state
                    } else {
                        board[row][col] = board[row][col] | 2; // Mark as live in the next state
                    }
                } else { // Current cell is dead
                    if (liveNeighbors == 3) {
                        board[row][col] = board[row][col] | 2; // Mark as live in the next state
                    }
                }
            }
        }
        
        // Update the board to the next state
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = board[row][col] >> 1;
            }
        }
    }
}
