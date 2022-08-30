class Solution {
    public void reverseString(char[] s) {
       gg(s, 0, s.length-1);
    }
    
    public void gg(char s[], int start, int end){
        if(start>=end )
            return;
        swap(s,start,end);
        gg(s, ++start, --end);
    }
    
    public void swap(char[] s, int i, int j){
        char tt= s[i];
        s[i]=s[j];
        s[j]=tt;
    }
}