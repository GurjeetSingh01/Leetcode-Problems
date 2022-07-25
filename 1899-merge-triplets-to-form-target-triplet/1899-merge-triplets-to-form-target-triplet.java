class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] ans = new int[3];
        
        for(int[] trip : triplets){
            if(isValid(trip, target)){
                if(trip[0] == target[0])ans[0] = trip[0];
                if(trip[1] == target[1])ans[1] = trip[1];
                if(trip[2] == target[2])ans[2] = trip[2];
                if(isFound(ans))return true;
            }
        }
        return false;
    }
    boolean isValid(int[] trip, int[] target){
        return trip[0] <= target[0] && trip[1] <= target[1] && trip[2] <= target[2];
    }
    
    boolean isFound(int[] ans){
        return ans[0] > 0 && ans[1] > 0 && ans[2] > 0;
    }
}