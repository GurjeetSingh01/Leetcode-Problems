// public class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         return combinationSum(candidates, target, 0);
//     }
    
//     public List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         Arrays.sort(candidates);
//         for (int i = start; i < candidates.length; i++) {
//             if (candidates[i] <target) {
//                 for (List<Integer> ar : combinationSum(candidates, target - candidates[i], i)) {
//                     ar.add(0, candidates[i]);
//                     res.add(ar);
//                 }
//             } else if (candidates[i] == target) {
//                 List<Integer> lst = new ArrayList<>();
//                 lst.add(candidates[i]);
//                 res.add(lst);
//             } else
//                 break;
//         }
//         return res;
//     }
// }

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        backtrack(candidates, target, ans, cur, 0);
        return ans;
    }

    public void backtrack(
        int[] candidates,
        int target,
        List<List<Integer>> ans,
        List<Integer> cur,
        int index
    ) {
        if (target == 0) {
            ans.add(new ArrayList(cur));
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            cur.add(candidates[index]);
            backtrack(candidates, target - candidates[index], ans, cur, index);

            cur.remove(cur.get(cur.size() - 1));
            backtrack(candidates, target, ans, cur, index + 1);
        }
    }
}


