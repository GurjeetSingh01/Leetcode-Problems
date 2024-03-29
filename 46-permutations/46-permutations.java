class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        permute(nums, 0, result);
        
        return result;
    }
    
    private void permute(int[] nums, int start, List<List<Integer>> result) {
        int n = nums.length;
        
        // All the permutations in the current path has been generated.
        if( start == n ) {
            result.add( new ArrayList<>( arrayToList( nums ) ));
            return;
        }
        
        for(int i=start; i<n; i++) {
            
            /* Swap the current number with the number at start to 
            generate next permutation */
            swap(nums, i, start);
            
            /* Fix the start, permute the number after start */
            permute(nums, start+1, result);
            
            /* Re-swap the current number with the number at start */
            swap(nums, i, start);
        }
    }
    
    private List<Integer> arrayToList(int[] arr) {
        List<Integer> lst = new ArrayList<>();
        for(int item : arr) {
            lst.add( item );
        }
        return lst;
    }
    
    private void swap(int[] arr, int i, int j) {
        if( i == j ) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}