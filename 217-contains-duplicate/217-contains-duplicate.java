public class Solution{
public boolean containsDuplicate(int[] nums){
HashSet<Integer> f1 = new HashSet<Integer>();
for(int i : nums){
if(!f1.add(i)){
return true;
}
}
return false; 
}}