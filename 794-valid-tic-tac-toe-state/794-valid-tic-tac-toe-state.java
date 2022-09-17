class Solution {
    int numX = 0;
    int numO = 0;
    
    public boolean validTicTacToe(String[] board) {
        
        //check condition 1 X counts should be equal or 1 greater than O count
        if(!countNumPossible(board)) return false;
        
        boolean winO = checkForWin(board, 'O');
        boolean winX = checkForWin(board, 'X');
        
        //both X and O can't win at same time
        if(winO && winX) {
            return false;
        }
        
        //if O wins then count of X and O should be same
        if(winO && this.numX-this.numO != 0) {
            return false;
        }
        
         //if X wins then count of X should be 1 greater than O
        if(winX && this.numX - this.numO != 1) {
            return false;
        }
        
        return true;
    }
    
    public boolean checkForWin(String[] board, char c) {
        //check horizontal
        for(String str: board) {
            for(int i=0; i<3; i++) {
                if(str.charAt(0) == c && str.charAt(1) == c && str.charAt(2) == c) {
                    return true;
                }
            } 
        }
        //check vertical
        if((board[0].charAt(0) == c && board[1].charAt(0) == c && board[2].charAt(0) == c) ||
           (board[0].charAt(1) == c && board[1].charAt(1) == c && board[2].charAt(1) == c) ||
           (board[0].charAt(2) == c && board[1].charAt(2) == c && board[2].charAt(2) == c)) {
            return true;
        }
        //check diagonal
        if((board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) || 
           (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c)) {
            return true;
        }
        return false;
    }
    
    public boolean countNumPossible(String[] board) {
        
        for(String str: board) {
            for(int i=0; i<3; i++) {
                if(str.charAt(i) == 'X') {
                    this.numX++;
                } else if(str.charAt(i) == 'O') {
                    this.numO++;
                }
            }
        }
        
        return this.numX - this.numO == 0 || this.numX - this.numO == 1;
    }
}