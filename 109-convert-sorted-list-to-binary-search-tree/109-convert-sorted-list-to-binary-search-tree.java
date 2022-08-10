class Solution {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        return buildBST(0, length(head) - 1);
    }
    TreeNode buildBST(int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode leftNode = buildBST(left, mid - 1);
        
        TreeNode root = new TreeNode(head.val); // root node is the mid node
        head = head.next; // go next
        
        root.left = leftNode;
        root.right = buildBST(mid + 1, right);
        return root;
    }
    int length(ListNode head) {
        int ans = 0;
        while (head != null) {
            head = head.next;
            ans++;
        }
        return ans;
    }
}
