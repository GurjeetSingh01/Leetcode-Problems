class Solution {
    public int reverse(int x) {
     int sign=1;
     if(x<0)
     {
         sign=-1;
         x=0-x;
     }
     long n=0;
     while(x>0)
     {
         long rem=x%10;
         n=n*10+rem;
         x=x/10;
     }
     if(n>Integer.MAX_VALUE)
         return 0;   
        
     return (int)n*sign;
    }
}