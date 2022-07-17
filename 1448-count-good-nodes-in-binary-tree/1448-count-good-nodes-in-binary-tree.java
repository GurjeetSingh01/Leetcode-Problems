class Solution {
    int goods = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,Integer.MIN_VALUE);
        
        return goods;
    }
    
    private void dfs(TreeNode root,int max){
        if(root == null)
            return;
        if(root.val >= max){
            goods+=1;
            max = root.val;
        }
        dfs(root.left,max);
        dfs(root.right,max);
    }
}