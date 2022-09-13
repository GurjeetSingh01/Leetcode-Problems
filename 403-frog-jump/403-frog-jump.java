class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> hm=new HashMap<>();
        
        for(int i=0;i<stones.length;i++){
            hm.put(stones[i],new HashSet<>());
        }
        
        hm.get(stones[0]).add(1);
        
        int n=stones.length;
        
        for(int i=0;i<n;i++){
            HashSet<Integer> hs=hm.get(stones[i]);
            
            for(int j:hs){
                int pos=stones[i]+j;
                
                if(pos==stones[n-1]){
                    return true; 
                }
                
                if(hm.containsKey(pos)){
                    if(j-1>0){
                        hm.get(pos).add(j-1);
                    }
                    
                    hm.get(pos).add(j);
                    hm.get(pos).add(j+1);
                }
            }
        }
        
        return false;
    }
}