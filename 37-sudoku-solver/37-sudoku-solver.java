class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    
                    for(char c = '1'; c <= '9'; c++){
                        
                        if(isValid(board, i, j, c)){
                            //if it is valid than put the c there
                            board[i][j] = c;
                            
                            //after putting call recursion
                            if(solve(board)){
                            //if we solve the board than return true;
                                return true;
                            }else{
                            //if we not able to solve put back the '.'
                            //backtrack    
                                board[i][j] = '.';
                            }
                        }  
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char board[][], int row, int col, char c){
        for(int i = 0; i < 9; i++){
            
            //for checking in the row
            if(board[i][col] == c){
                return false;
            }
            
            //for checking in the col
            if(board[row][i] == c){
                return false;
            }
            
            //for checking in the 3 * 3 box
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3 ] == c){
                return false;
            }
        }
        return true;
    }
}