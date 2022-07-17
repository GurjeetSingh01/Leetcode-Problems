class Solution {
  public int maximumSum(int[] nums){
HashMap<Integer, Integer> mp = new HashMap<>();
int max =-1;
for(int n: nums){
int sum = calc(n);
if(mp.containsKey(sum)){
max = Math.max(max, mp.get(sum)+n);
}

int maxNum = Math.max(mp.getOrDefault(sum,0),n);
mp.put(sum, maxNum);
}
return max; 
}
private int calc(int n){
int res = 0; 
while(n !=0){
res += n%10;
n /=10;
}
return res;
}
}