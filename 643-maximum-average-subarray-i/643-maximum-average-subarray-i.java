class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+= nums[i]; 
        }
        int max=sum;
        int p=0,q=k;
        for (int i=0;i<nums.length-k;i++){
            sum+=(nums[q++]-nums[p++]);
            if(sum>max) max=sum;
        }
        return (double)max/k;
        
    }
}