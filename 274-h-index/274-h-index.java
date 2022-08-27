class  Solution {
public int hIndex(int[] citations){
int m = citations.length; 
int buck[] = new int[m+1];
for(int c: citations){
if(c>m){
buck[m]++;
}
else{
buck[c]++;}}
int s = 0;
for(int i =m; i>=0; i--){
s+=buck[i];
if(s>=i){
return i;
}}
return 0;
}}