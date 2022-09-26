class Solution {
    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        
        int leftAns = sumOfLeftLeaves(root.left, true);
        int rightAns = sumOfLeftLeaves(root.right, false);
        
        return leftAns+rightAns;
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }
}