class Solution {
public int change(int amount, int[] coins) {
if(amount==0)return 1;

    if(coins.length==1 && coins[0]==amount)return 1;
    int dp[][]=new int[amount+1][coins.length+1];
    for(int i[]: dp){
        Arrays.fill(i,-1);
    }
    
    return count(amount,coins,0,coins.length,dp);
}
int count(int sum,int coin[],int i,int n,int dp[][]){
    if(sum==0)return 1;
    if(i>=n || sum<0)return 0;
    
    if(dp[sum][i]!=-1)return dp[sum][i];
    
    int in=count(sum-coin[i],coin,i,n,dp);
    int en=count(sum,coin,i+1,n,dp);

    return dp[sum][i]=in+en;
}
}