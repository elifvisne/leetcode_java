class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int N = 9; 

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solve(board))
                                return true;
                            board[i][j] = '.'; 
                        }
                    }
                    return false; 
                }
            }
        }

        return true; 
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int N = 9; 

       
        for (int i = 0; i < N; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
