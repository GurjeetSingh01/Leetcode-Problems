class Solution{
public int numSubmatrixSumTarget(int[][] matrix, int target){
int res = 0;
for(int i =0;i <matrix[0].length; i++){ //left col
int[] sum = new int[matrix.length];
for(int m =i; m<matrix[0].length;m++){ //right col
for(int j =0; j<matrix.length; j++){
sum[j] += matrix[j][m]; //add left to right
if(sum[j] == target) res++;
}
for(int j =0; j<matrix.length; j++){// up row
int sumii=0;
for(int n = j; n<matrix.length; n++){// down row
sumii += sum[n]; // add up to down 
if(n  != j && sumii == target) res++;
}}}}
return res;
}}
