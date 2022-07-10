// class Solution {
//     public int[] twoSum(int[] nums, int target){
// int l = 0, r = nums.length-1; 
// while(nums[l] + nums[r] != target){
// if(nums[l] + nums[r] < target) l++;
// else r-- ; 
// }
// return new int[] {l+1, r+1};
// }
// }

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;
        int num_a, num_b;
        
        while(a_pointer < b_pointer) {
            num_a = numbers[a_pointer];
            num_b = numbers[b_pointer];
            
            if(num_a + num_b == target) break;
            
            if(num_a + num_b < target) {
                a_pointer++;
                continue;
            }
            
            b_pointer--;
            
        }
        
        return new int[]{a_pointer + 1, b_pointer + 1};
    }
}