class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int k = matrix[0].length-1, r = 0;
        
        while(k >= 0 && r < matrix.length){
            if(matrix[r][k] == target) return true;
            else if(matrix[r][k] > target) k--;
            else r++;
        }
        
        return false;
    }
}