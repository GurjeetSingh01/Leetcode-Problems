class Solution {
    public void rotate(int[][] matrix) {
        
        //1. In-place transpose of the matrix... Traversing in the lower triangle.
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j = 0; j<i; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        
     
        //2. Reversing the array by columns        
        int p1 = 0, p2 = n-1;
        
        while(p1<p2){
            
            for(int i=0; i<m; i++){
                int t = matrix[i][p1];
                matrix[i][p1] = matrix[i][p2];
                matrix[i][p2] = t;
            }
            
            p1++;
            p2--;
            
        }
        
    }
}