class Solution {
    public int longestConsecutive(int[] nums){
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums)
        hs.add(i);
        int maxo=0;
        for(int i: nums){
            if(!hs.contains(i-1)){
                int k = 1;
                while(hs.contains(i+1)){
                    k++;
                    i++;
                }
                maxo = Math.max(maxo, k);
            }
        }
        return maxo;
    }
}