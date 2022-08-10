public class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums.length==0)return null;
            int ptr=nums.length/2;
            TreeNode root=new TreeNode(nums[ptr]);
            root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,ptr));
            root.right=sortedArrayToBST(Arrays.copyOfRange(nums,ptr+1,nums.length));
            return root;
        }
    }