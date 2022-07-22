class Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    int max = nums[0];
    int currMax = nums[0];
    int currMin = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int currMaxCopy = currMax;
        currMax = Math.max(Math.max(nums[i], currMax * nums[i]), currMin * nums[i]);
        currMin = Math.min(Math.min(nums[i], currMin * nums[i]), currMaxCopy * nums[i]);
        max = Math.max(max, currMax);
    }

    return max;
}
}