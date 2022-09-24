/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        findans(root,targetSum,list,inner);
        return list;
    }
    
    private void findans(TreeNode root,int targetSum,List<List<Integer>> outer,
                 List<Integer> inner){
        
        if(root == null) return;  //base case
        inner.add(root.val);
        
        if(root.left == null && root.right == null && root.val == targetSum){ //base case
                outer.add(new ArrayList<>(inner));
        }else{
            findans(root.left,targetSum - root.val,outer,inner);
            findans(root.right,targetSum - root.val,outer,inner);
        }
        
         inner.remove(inner.size() - 1);
    }
}