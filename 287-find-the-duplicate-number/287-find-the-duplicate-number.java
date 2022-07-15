class Solution {
public int findDuplicate(int[] nums) {
    //Sorting the array in ascending order.
    Arrays.sort(nums);
    
    //Runs a for loop through out the array.
    for (int i = 0; i < nums.length; i++) {
	
        //Check for the next number is equal to previous number.
        if (i != nums.length && nums[i] == nums[i+1]) {
		
            //Return that number.
            return nums[i];
        }
    }
    
    //If no numbers are equal then return -1.
    return -1;
	}
}