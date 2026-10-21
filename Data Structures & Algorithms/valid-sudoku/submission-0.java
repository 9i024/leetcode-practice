class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = 9;
        for(int i = 0; i < size; i++){
            HashSet<Character> row = new HashSet<>();
            for(int j = 0; j < size; j++){
                if(board[i][j] == '.') continue;
                if(row.contains(board[i][j])) return false;
                row.add(board[i][j]);
            }
        }

        for(int i = 0; i < size; i++){
            HashSet<Character> col = new HashSet<>();
            for(int j = 0; j < size; j++){
                if(board[j][i] == '.') continue;
                if(col.contains(board[j][i])) return false;
                col.add(board[j][i]);
            }
        }

        for(int i = 0; i < size; i++){
            HashSet<Character> square = new HashSet<>();
            for(int j = 0; j < size; j++){
                if(board[(i/3)*3+(j/3)][(i % 3) * 3 + j % 3] == '.') continue;
                if(square.contains(board[(i/3)*3+(j/3)][(i % 3) * 3 + j % 3])) return false;
                square.add(board[(i/3)*3+(j/3)][(i % 3) * 3 + j % 3]);
            }
        }
        return true;
    }
}
