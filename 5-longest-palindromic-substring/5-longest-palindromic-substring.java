class Solution {
//     public String longestPalindrome(String s) {
        
//     }
// }

public String longestPalindrome(String s) {
boolean[][] dp = new boolean[s.length()][s.length()];
int start =0, end =0;
for(int gap =0; gap<s.length(); gap++){
for(int i =0, j = gap; j<dp[0].length; i++, j++)
{
if(gap==0){
dp[i][j]= true; 
continue;}
if(gap ==1 && s.charAt(i) == s.charAt(j)){
dp[i][j] = true; }
else if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
dp[i][j]= true; }
if(dp[i][j] ){
start = i; 
end =j; 
}}}
return s.substring(start, end +1);
}
}