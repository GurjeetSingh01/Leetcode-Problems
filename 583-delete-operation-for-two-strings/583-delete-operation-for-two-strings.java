class Solution {
    int [][] dp;
    public int minDistance(String word1, String word2) {
        this.dp = new int[word1.length() + 1][word2.length() + 1];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        
        return word1.length() - dp[word1.length()][word2.length()] +
               word2.length() - dp[word1.length()][word2.length()];
        
        /*Simply find LCS of both strings.now this lcs is the common part of 
          both string and to make strings equal we need to delete all the
          chars of both strings which are not part of LCS */
    }
}