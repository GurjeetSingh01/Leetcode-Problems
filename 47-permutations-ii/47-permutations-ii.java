class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Arrays.sort(nums);
        
        dfs(list, list1, nums, new boolean[nums.length]);
        return list;
    }
    
    public void dfs(List<List<Integer>> list, List<Integer> list1, int[] nums, boolean[] used) {
        if (list1.size() == nums.length) {
            list.add(new ArrayList<>(list1));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            list1.add(nums[i]);
            used[i] = true;
            dfs(list, list1, nums, used);
            list1.remove(list1.size() - 1);
            used[i] = false;
        }
    }
}