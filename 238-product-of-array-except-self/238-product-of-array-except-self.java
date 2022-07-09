import java.util.*;
public class Solution {
public int[] productExceptSelf(int[] nums){
int[] result = new int[nums.length];
result[nums.length-1] =1;
for(int i = nums.length-2; i>=0; i--){
result[i] = result[i+1] * nums[i+1];
}
int lft =1;
for(int i =0; i<nums.length; i++){
result[i] = result[i] * lft ;
lft = lft *nums[i];
}
return result;
}
}
// public static void main(String[] args){
// ProductOfArrayExceptSelf ps = new ProductOfArrayExceptSelf();
// System.out.println(Arrays.toString(ps.productExceptSelf(new int[] {1,2,3,4})));
// System.out.println(Arrays.toString(ps.productExceptSelf(new int[]{-1,1,0,-3,3})));
// }}
