class Solution {
    public boolean isPossible(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        HashMap<Integer, Integer> want = new HashMap<Integer, Integer>();
        
        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i])==0){
                continue;
            }
            if(want.getOrDefault(arr[i],0)>0){
                map.put(arr[i],map.get(arr[i])-1);
                want.put(arr[i], want.getOrDefault(arr[i],0)-1);
                want.put(arr[i]+1, want.getOrDefault(arr[i]+1,0)+1);
            }
            else if(map.getOrDefault(arr[i],0)>0 && map.getOrDefault(arr[i]+1,0)>0 && map.getOrDefault(arr[i]+2,0)>0){
                map.put(arr[i],map.get(arr[i])-1);
                map.put(arr[i]+1,map.get(arr[i]+1)-1);
                map.put(arr[i]+2,map.get(arr[i]+2)-1);
                
                want.put(arr[i]+3, want.getOrDefault(arr[i]+3,0)+1);
            }else{
                return false;
            }
        }
        return true;
    }
}