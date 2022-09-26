class Solution {
    public long numberOfWays(String s) {
        // '0' denotes that the ith building is an office 
        // '1' denotes that the ith building is a restaurant
        //  0 0 1 1 0 1  -> 0 1 1 which is not allowed due to having two consecutive buildings of the same type
        // Input:  0 0 1 1 0 1
        // Output: 6
        // THERE ARE ONLY 2 VALID PATTERNS: '101' AND '010'
        // COUNT THE NO. OF SUBSEQUENCES OF THE FORM '01' OR '10' FIRST.
        int gg = s.length();
        long n0 = 0;
        long n1 = 0;
        long n01 = 0;
        long n10 = 0;
        long n010 = 0;
        long n101 = 0;
        
        for(int i = 0; i < gg; i++){
            char ch = s.charAt(i);
            if(ch == '0'){
                n0++;
                n10 += n1;
                n010 += n01;
            }
            else{
                n1++;
                n01 += n0;
                n101 += n10;
            }
        }
        
        return n010 + n101;
    }
}
