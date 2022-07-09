class Solution {
public List<List<String>> groupAnagrams(String[] strs){
Map<String, ArrayList<String>> mp = new HashMap<String, ArrayList< String>>();
for(String st: strs){
char[] ch = st.toCharArray();
Arrays.sort(ch);
String sp = String.valueOf(ch);
if(!mp.containsKey(sp))  
mp.put(sp, new ArrayList<String>());
mp.get(sp).add(st);
}
return new ArrayList<>(mp.values());
}}