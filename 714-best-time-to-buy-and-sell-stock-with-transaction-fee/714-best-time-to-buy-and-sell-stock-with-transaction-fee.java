
class Solution {
    public int maxProfit(int[] prices, int fee) {
        //dp array
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,prices,fee,dp);
    }
    int solve(int index,int own,int prices[],int fee,int dp[][]){
        if(index==prices.length)
            return 0;
        
        if(dp[index][own]!=-1){
            return dp[index][own];
        }
        
        //don't have any stock  
        if(own==0){//2 choices : 1.buy / 2. don't buy
            
            //buy and move forward
            int a=-(prices[index]+fee)+solve(index+1,1,prices,fee,dp);
            
            //move forward without buying
            int b=solve(index+1,0,prices,fee,dp);
            
            return dp[index][own]=Math.max(a,b);
            
        //owning a stock
        }else{//2 choices : 1.sell / 2. don't sell
            
            //sell and move forward
            int a=(prices[index])+solve(index+1,0,prices,fee,dp);
            
            //move forward without selling 
            int b=solve(index+1,1,prices,fee,dp);
            
            return dp[index][own]=Math.max(a,b);
        }
        
    }
	//hey if you find this helpful please upvote
}