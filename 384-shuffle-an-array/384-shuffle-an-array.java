class Solution {

   int a[];
int c[];
public Solution(int[] n){
    int k = n.length, p =0;
    a = new int[k];
    c = new int[k];
    for(int i:n){
        a[p]=i;
        c[p++]=i;
    }
}
public int[] reset(){
    return a;
}
public int[] shuffle(){
    int k = c.length;
    while(k>0){
        int p = (int)(Math.random()*k);
        int d = c[k-1];
        c[k-1] = c[p];
        c[p] = d;
        k-=1;
    }
    return c;
}
}