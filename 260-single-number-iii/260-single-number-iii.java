class Solution {
    public int[] singleNumber(int[] nums) {
        int uni=0;
        for(int i=0;i<nums.length;i++)
        {
            uni^=nums[i];
            
        }
        int rsbm=uni&-uni;
        int uni1=0;
        int uni2=0;
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i] & rsbm)==0)
            {
                uni1^=nums[i];
            }
            else
            {
                uni2^=nums[i];
            }
                
        }
        int[] res=new int[2];
        res[0]=uni1;
        res[1]=uni2;
        return res;
        
    }
}