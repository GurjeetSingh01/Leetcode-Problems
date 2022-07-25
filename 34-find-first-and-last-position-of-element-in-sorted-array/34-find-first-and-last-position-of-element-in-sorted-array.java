class Solution {
public int[] searchRange(int[] nums, int target) {
int start = 0;
int end = nums.length-1;
int ans[] = {-1, -1};

    while(start <= end){
        int mid = start + (end - start)/2;
        
        if(nums[mid] == target){
            ans[0] = mid;
            end = mid - 1;
        }
        
        else if(nums[mid] > target){
            end = mid - 1;   
        }
        
        else{
            start = mid + 1;
        }
    }
    
    int s = 0;
    int e = nums.length-1;
    
    while(s <= e){
        int mid = s + (e - s)/2;
        
        if(nums[mid] == target){
            ans[1] = mid;
            s = mid + 1;
        }
        
        else if(nums[mid] > target){
            e = mid - 1;   
        }
        
        else{
            s = mid + 1;
        }
    }
    return ans;
}
}