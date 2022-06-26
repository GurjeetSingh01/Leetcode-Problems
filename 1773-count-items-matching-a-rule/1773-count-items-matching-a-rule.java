class Solution {
public int countMatches(List<List<String>> items, String ruleKey, String ruleValue){
int res = 0;
int checkRuleNum = 0;
if(ruleKey.equals("color")) checkRuleNum =1;
else if(ruleKey.equals("name")) checkRuleNum = 2; 
for(int i =0; i<items.size(); i++)
if((items.get(i).get(checkRuleNum)).equals(ruleValue)) res++;
return res; 
}}
