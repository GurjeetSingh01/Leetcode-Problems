class Solution {
public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n+1][m+1];
        for(int[] num : memo)
            Arrays.fill(num, -1);
        return minPathSum(0,0,n,m,grid, memo);
    }
    
    public int minPathSum(int i, int j, int n, int m, int[][] grid, int[][] memo){
        if(i >= n || j >=m)
            return Integer.MAX_VALUE;
        
        if(i == n-1 && j == m-1)
            return grid[i][j];
        if(memo[i][j] != -1)
            return memo[i][j];
        return memo[i][j] = grid[i][j] + Math.min(minPathSum(i+1, j, n, m,grid, memo), minPathSum(i, j+1, n,m,grid,memo));
    }
}