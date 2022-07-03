class Solution {
   public int coinChange(int[] coins, int amount) {
    int[] arrayDp = new int[amount + 1];
    for(int i = 1; i <= amount; i++){
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            if(i >= coin){
                if(arrayDp[i - coin] == -1){
                    continue;
                }else{
                    min = Math.min(min, arrayDp[i-coin] + 1);
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            arrayDp[i] = -1;
        }else{
            arrayDp[i] = min;
        }
    }
    return arrayDp[amount];
}
}