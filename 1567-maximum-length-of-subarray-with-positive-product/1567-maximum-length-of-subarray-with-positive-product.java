class Solution {
public int getMaxLen(int[] nums) {
        int maxLength = 0;
        int product = 1;
        int prev = -1;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            product = (product * num);
			// we don't wanna overflow 
            if(product != 0) product = product / Math.abs(product);
            
            if(product == 0) {
                product = 1;
                prev = i;
            } else if(product > 0) {
                maxLength = Math.max(maxLength, (i - prev));
            }
        }
        
        product = 1;
        prev = nums.length;
        for(int i = nums.length - 1; i >= 0; i--){
            int num = nums[i];
            product *= num;
            if(product != 0) product = product / Math.abs(product);
            
            if(product == 0) {
                product = 1;
                prev = i;
            } else if(product > 0){
                maxLength = Math.max(maxLength, (prev - i));
            }
        }
        
        return maxLength;
    }
}