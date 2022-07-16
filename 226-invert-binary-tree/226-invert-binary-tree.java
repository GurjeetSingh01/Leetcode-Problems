class Solution{
public TreeNode invertTree(TreeNode root) {
if (root == null)
return root;
TreeNode f1 = root.left;
root.left = invertTree(root.right);
root.right = invertTree(f1);
return root;
}}
