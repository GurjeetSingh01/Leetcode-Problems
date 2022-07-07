public class Solution{
public boolean isAnagram(String s, String t){
if(s.length() != t.length()) return false; 
char[] cs = s.toCharArray();
char[] ct = t.toCharArray();
int[] map = new int[127];
int cnt =0;
for(int i =0; i<cs.length; i++){
if(++map[cs[i]] ==1) cnt++;
if(--map[ct[i]] == 0) cnt--;
}
return cnt==0;
}}
