class Solution {
   public static int count=0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0) return 0;
        int res=0;
        
        for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
                  if(grid[i][j]==1){
                       count=0;
                      floodfill(grid,i,j);
                      if(res<count){
                          res=count;
                      }
                  }
           }
        }
        return res;
    }
    public static void floodfill(int[][] grid ,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;
        
        grid[i][j]=0;// marking it so that it would not be handled further as it is handled this time
        count++;
        
        floodfill(grid,i+1,j);
        floodfill(grid,i-1,j);
        floodfill(grid,i,j-1);
        floodfill(grid,i,j+1);
        
    }
}