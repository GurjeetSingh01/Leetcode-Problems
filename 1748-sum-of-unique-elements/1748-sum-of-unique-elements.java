class Solution {
 public int sumOfUnique(int[] nums) {
   int[] arr = new int[101];
     int count=0;
        for(int n:nums){
            arr[n]++;
        }
     for(int i=0;i<arr.length;i++){
         if(arr[i] == 1){
             count +=i;
         }
     }
     return count;
    }
}