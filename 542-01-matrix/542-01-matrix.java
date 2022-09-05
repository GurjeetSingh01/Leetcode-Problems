class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
		// iterate thru top left to bottom right
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0; 
                }
                else{
                    ans[i][j] = m * n;
                    //up
                    if(i != 0){
                        ans[i][j] = Math.min(ans[i - 1][j] + 1, ans[i][j]);
                    }
                    //left
                    if(j != 0){
                        ans[i][j] = Math.min(ans[i][j - 1] + 1, ans[i][j]); 
                    }
                } 
            }  
        }
		// iterate thru bottom right to top left
        for(int i = m - 1; i>=0; i--){
            for(int j = n - 1; j>= 0; j--){
                if(ans[i][j] != 0){
                    //down
                    if(i != m - 1){
                        ans[i][j] = Math.min(ans[i + 1][j] + 1, ans[i][j]);  
                    }
                    //right
                    if(j != n - 1){
                        ans[i][j] = Math.min(ans[i][j + 1] + 1, ans[i][j]);
                    } 
                }     
            } 
        }    
        return ans;
    }
}