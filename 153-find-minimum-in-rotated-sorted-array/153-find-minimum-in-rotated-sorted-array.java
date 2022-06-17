public class Solution {
public int findMin(int[] num ) {
if(num == null || num.length ==0){
return 0;
}
if(num.length ==1){
return num[0];
}
int st =0, end =num.length -1; 
while(st<end) {
int mid = (st+end)/2;
if(mid>0 && num[mid] <num[mid-1]){
return num[mid];
}
if(num[st]<= num[mid] && num[mid] > num[end]){
st = mid+1; 
}
else {
end = mid-1; 
}}
return num[st]; 
}}
