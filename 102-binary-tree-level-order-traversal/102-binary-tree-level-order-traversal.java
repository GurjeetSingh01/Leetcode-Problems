public class Solution {
      public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         if (root == null)
//             return res;
//         Queue<TreeNode> q = new LinkedList<TreeNode>();
//         q.offer(root);
//         while (!q.isEmpty()) {
//             List<Integer> tmp = new ArrayList<Integer>();
//             int size = q.size();
//             for (int i = 0; i < size; ++i) {
//                 TreeNode t = q.poll();
//                 if (t.left != null)
//                     q.offer(t.left);
//                 if (t.right != null)
//                     q.offer(t.right);
//                 tmp.add(t.val);
//             }
//             res.add(tmp);
//         }
//         return res;
//     }
// }

          
           Queue<TreeNode> queue = new LinkedList<TreeNode>();
    
    List<List<Integer>> fList = new LinkedList<List<Integer>>();
    
    if(root == null) {
        return fList;
    }
    
    queue.offer(root);
    
    while(!queue.isEmpty()) {
        int levSum = queue.size();
        List<Integer> sublist = new LinkedList<Integer>();
        for(int i=0; i<levSum; i++) {
            if(queue.peek().left != null) {
                queue.offer(queue.peek().left);
            } if(queue.peek().right != null) {
                queue.offer(queue.peek().right);
            }
            sublist.add(queue.poll().val);
        }
        fList.add(sublist);
    }
    
    return fList;
}}



