class Solution {
    // 1: Traverse row, col, matrix.
    // 2: Create 
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if( set.add(board[i][j]+" in row "+i) &&
                    set.add(board[i][j]+" in col "+j) &&
                    set.add(board[i][j]+" in block "+ i/3 +" - "+j/3)){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}