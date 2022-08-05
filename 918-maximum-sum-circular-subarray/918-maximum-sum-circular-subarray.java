class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // find max subrange array within [0, nums.length -1]
        // for scenario that max subrange may be inside [0, nums.length -1] [---+++++----]
        int totalSum = 0;
        int current = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(current, max);
        }
        int min = Integer.MAX_VALUE;
        current = 0;
        // find min subrange array within [0, nums.length -1]
        // for scenario that max subrange may be on both sides [0, nums.length -1] [++----+++]
        // max = totalsum - min
        for (int i = 0; i < nums.length; i++) {
            current = Math.min(current + nums[i], nums[i]);
            min = Math.min(current, min);
        }
        // All non-positive numbers 
        if (min == totalSum) {
            return max;
        }
        return Math.max(totalSum - min, max);
    }
}