class Solution {
    public int[] runningSum(int[] nums) {
        int g =1; 
        while(g<nums.length){
            nums[g] += nums[g-1];
            g++;
        }
        return nums; 
    }
}