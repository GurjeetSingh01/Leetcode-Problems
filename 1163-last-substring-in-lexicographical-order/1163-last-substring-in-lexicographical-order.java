class Solution {
public String lastSubstring(String s){
int maxidx = s.length()-1;
for(int  curridx = s.length() -1 ; curridx >=0; curridx--){
if(s.charAt(curridx) > s.charAt(maxidx))
maxidx = curridx;
else if(s.charAt(curridx) == s.charAt(maxidx)){
int i = curridx +1;
int j = maxidx +1;
while(i<maxidx && j<s.length() && s.charAt(i) == s.charAt(j)){
i++;
j++;
}
if(i == maxidx || j == s.length() || s.charAt(i) > s.charAt(j))
maxidx = curridx; 
}}
return s.substring(maxidx);
}
}