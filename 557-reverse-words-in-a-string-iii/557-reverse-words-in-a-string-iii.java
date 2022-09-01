class Solution {
   public String reverseWords(String s) {
    
    String[] t=s.split("\\s");
    StringBuffer b=new StringBuffer();
    
    for(int i=0;i<t.length;i++)
    {
        char[] a=t[i].toCharArray();
        int k=0,j=a.length-1;
        while(k<j)       //Reverse each word
        {
            char tmp=a[k];
            a[k]=a[j];
            a[j]=tmp;
            k++;
            j--;
        } 
        b.append(String.valueOf(a)+" ");
    }
    return b.toString().trim();
    
} 
}