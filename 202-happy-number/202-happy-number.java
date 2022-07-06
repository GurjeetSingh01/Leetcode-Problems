class Solution{
public int sumOfSquare(int num){
int sum =0; 
while(num !=0){
sum += (num%10) *(num%10);
num = num/10;
}
return sum;
}
public boolean isHappy(int n){
HashSet<Integer> set = new HashSet<>();
while(!set.contains(n)) {
set.add(n);
n = sumOfSquare(n);
if(n==1) return true;
}
return false;
}}
