class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo =0; 
        int high=nums.length-1;
        while(lo<=high){
            int mid = (lo+high)/2;
            if(nums[mid] ==target) return mid; 
            else if(nums[mid]>target) high = mid -1;
            else lo = mid +1; 
        }
        return lo; 
        
    }
}
