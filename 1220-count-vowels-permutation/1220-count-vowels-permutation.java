class Solution {

public int countVowelPermutation(int n) {
    
    //a : 0, e : 1, i : 2, o : 3, u : 4
    
    //a -> e
    //e -> a , i 
    //i -> a, e, o, u
    //o -> i, u
    //u -> a
    
    long[][] dp = new long[n+1][5];
    int module = (int) 1e9+7;
	
	//init
    dp[0][0] = 1;
    dp[0][1] = 1;
    dp[0][2] = 1;
    dp[0][3] = 1;
    dp[0][4] = 1;
    
    for(int i = 1; i < n; i++) {
        dp[i][0] = dp[i-1][1]%module;
        dp[i][1] = (dp[i-1][0] + dp[i-1][2])%module;
        dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4])%module;
        dp[i][3] = (dp[i-1][2] + dp[i-1][4])%module;
        dp[i][4] = (dp[i-1][0])%module;            
    }
    
return (int) ((dp[n-1][0] + dp[n-1][1] + dp[n-1][2] + dp[n-1][3] + dp[n-1][4])%module);
}
}