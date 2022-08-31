// public class Solution {
// public void moveZeroes(int[] nums) {

//     //if only 1 element is present, return
//     if(nums.length==1)
//         return;

//     int i=0;
    
//     //iterate through the array counting number of zeros
//     for(int k:nums)
//     {
//         if(k==0)
//             i++;
//     }
        
//     //if no 0's exists or array only contains zeros , return
//     if(i==0 || i==nums.length)
//         return;
    
//     //index to keep track of non-zero elements
//     int m=0;
    
//     //for loop to move all the non zero elements in order
//     for(int j=0;j<nums.length;j++)
//     {
//         if(nums[j]!=0)
//             nums[m++]=nums[j];
//     }
    
//     //insert the 0's in remaining spaces up till the end
//     for(int j=nums.length-i;j<nums.length;j++)
//     {
//         nums[j]=0;
//     }
    
    
    
    
    
// }
// }



class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){// we will shift all the non zero values to right
                nums[index]=nums[i];
                index++;// keep on increasing the index as well
            }
        }
        for(int i= index; i<nums.length;i++){ //now we will replace all the remaing indexes with zero
            nums[i]=0;
        }
    }
}