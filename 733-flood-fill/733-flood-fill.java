class Solution {
    
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
   int o=image[sr][sc];
    helper(image,sr,sc,newColor,o);
    return image;
   
}

void helper(int[][] img,int r,int c,int n,int o) {
    if(r>=img.length || c>=img[0].length || r<0 || c<0 || img[r][c]==n || img[r][c]!=o)   return;
    img[r][c]=n;
    helper(img,r+1,c,n,o);
    helper(img,r-1,c,n,o);
    helper(img,r,c+1,n,o);
    helper(img,r,c-1,n,o);
}
}
