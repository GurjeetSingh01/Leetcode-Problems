class Solution {
public int firstUniqChar(String s){
int rr = Integer.MAX_VALUE;
for(char c = 'a'; c<='z'; c++){
int idx = s.indexOf(c);
if(idx != -1 && idx == s.lastIndexOf(c)){
rr = Math.min(rr, idx);
}}
return rr==Integer.MAX_VALUE? -1:rr;
}}