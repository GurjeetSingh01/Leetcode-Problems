class Solution {
public String reverseWords(String s){
    StringBuilder rev= new StringBuilder();
    int g = s.length();
    for(int i =s.length()-1; i>=0; i--){
        if(s.charAt(i)== ' '){
            g=i;
        }
        else if (i==0 || s.charAt(i-1) == ' ') {
            if(rev.length() !=0){
                rev.append(' ');
            }
            rev.append(s.substring(i,g));
        }
    }
    return rev.toString();
}
}