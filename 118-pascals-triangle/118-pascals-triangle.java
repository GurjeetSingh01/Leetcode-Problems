class Solution {
public List<List<Integer>> generate(int numRows){
List<List<Integer>> outter = new ArrayList<List<Integer>>();
    List<Integer> inner = new ArrayList<>();
for(int i =0; i<numRows; i++){
int val =1;
inner = new ArrayList<>();
inner.add(1);
for(int j =0; j<i; j++){
val = (val*(i-j))/(j+1);
inner.add(val);
}
outter.add(inner);
}
return outter;
}}
