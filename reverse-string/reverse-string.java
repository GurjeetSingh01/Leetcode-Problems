class Solution {
    public void reverseString(char[] s) {
      dd(s,0,s.length-1);
    }
    public void dd(char s[], int start, int end){
        if(start>=end) return;
        swap(s,start, end);
        dd(s, ++start, --end);
    }
    public void swap(char[] s, int i, int j){
        char tt = s[i];
        s[i]=s[j];
        s[j]=tt;
    }
}