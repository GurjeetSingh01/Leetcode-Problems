class Solution {
    public int deleteAndEarn(int[] nums) {
	   int[] dp = new int[10001];
        
        for(int num : nums) {
        	dp[num] += num;
        }
        
        for(int i = 2; i < dp.length; i++) {
        	dp[i] = Math.max(dp[i] + dp[i-2], dp[i-1]);
        }
        return dp[10000];
    }
}