class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    int digit = current - '0';
                    if (seen[digit])
                        return false;
                    seen[digit] = true;
                }
            }
        }

        // Check each column
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for (int i = 0; i < 9; i++) {
                char current = board[i][j];
                if (current != '.') {
                    int digit = current - '0';
                    if (seen[digit])
                        return false;
                    seen[digit] = true;
                }
            }
        }

        // Check each 3x3 sub-box
        for (int box = 0; box < 9; box++) {
            boolean[] seen = new boolean[10];
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    char current = board[i][j];
                    if (current != '.') {
                        int digit = current - '0';
                        if (seen[digit])
                            return false;
                        seen[digit] = true;
                    }
                }
            }
        }

        return true;
    }
}
