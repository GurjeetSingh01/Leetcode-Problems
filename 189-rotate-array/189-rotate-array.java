class Solution {
     public void rotate(int[] nums, int k) {
//        Marks the correct index of a number
        int index = 0;
//        Marks the index of the array.
        int i = 0;
//        Marks the number of iterations in the array.
        int iterations = 0;
        while(iterations < nums.length){
           if((index+k)% nums.length == i){
               i++;
               index = i;
               iterations++;
           }else{
               swap(nums,i,(index+k)%nums.length);
               index = (index+k)%nums.length;
               iterations++;
           }
        }
    }

    void swap(int [] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}