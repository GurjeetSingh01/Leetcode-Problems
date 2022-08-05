
//Approach 2: 92% Faster Dynamic Programming -  Bottom Up Approach
// Time Complexity: O(n*target) | Space Complexity: O(target)
class Solution {
    static int[] dp;
    public int combinationSum4(int[] nums, int target) {
        
        dp = new int[target + 1];

        dp[0] = 1;
        for(int i=1; i<=target; i++){
            for(int n : nums){
                if(i>=n){
                    dp[i] += dp[i-n];
                }
            }
        }
        return dp[target];
    }
}
        
