class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int n = values.length;
        int ans = Integer.MIN_VALUE;
        int sum = values[0] + 0;
        
        //sum 8+0  max(8,1+1)  max(8 , 5+2) , max(8 , 2 + 3) , max(8 , 6 + 4)    // 8 8 8 8 10
        // for next one 1st value will be 0 cuz otherwise there will be no room for i as same index is not alowed
        
        // 0  max(-2^31 , 8 + 1 - 1)  max(8 , 8 + 5 - 2)  max(11 , 8 + 2 - 4) max(11 , 8 + 6 - 5) // 0 8 11 11 11 
        
        for(int j = 1 ; j<n ; j++)
        {
            ans = Math.max(ans , sum + values[j] - j);
            sum = Math.max(sum , values[j] + j);
        }
        return ans;
    }
}