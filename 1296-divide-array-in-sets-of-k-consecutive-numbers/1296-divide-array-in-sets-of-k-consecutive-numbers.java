class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length == k) return false;
        
        int n = nums.length;
        if(n % k == 1) return false;
        
        // we will traverse the sorted array and map its elements vs freq
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>(); // to check the frequency of occurence of elements
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for(int ele : nums){
            if(map.containsKey(ele) == true){
                for(int i= 1; i < k; i++){
                    if(map.containsKey(ele + i) == false){ // if consecutive element not found directly return false
                        return false;
                    } // if the next consecutive element found then decrease its frequency so that next time it doesn't gets add up
                    if(map.get(ele + i) == 1){
                        map.remove(ele + i);
                    }else{
                        map.put(ele + i, map.get(ele + i) - 1);
                    }
                } // finally decrease the frequency of that particular element found
                if(map.get(ele) == 1){
                    map.remove(ele);
                }else{
                    map.put(ele, map.get(ele) - 1);
                }
            }
            
        }
        return true;
    }
}


ad
fafa,,a
faf
kkjaweerwfsd
yey
