
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

    if(root==null)
        return new ArrayList<Integer>();
    List<Integer> left = rightSideView(root.left);
    List<Integer> right = rightSideView(root.right);
    List<Integer> re = new ArrayList<Integer>();
    re.add(root.val);
    for(int i=0;i<Math.max(left.size(), right.size());i++){
        if(i>=right.size())
            re.add(left.get(i));
        else
            re.add(right.get(i));
    }
    return re;
}
    }