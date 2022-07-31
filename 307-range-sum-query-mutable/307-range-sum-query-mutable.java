class NumArray {

    int[] segment;
    int n;
    
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.segment = new int[4 * n];
        makeSegmentTree(nums, 1, 0, n - 1);
    }
    
    private void makeSegmentTree(int[] nums, int pos, int start, int end){
        if(start == end){
            this.segment[pos] = nums[start];
            return;
        }
        
        int mid = start + (end - start) / 2;
        makeSegmentTree(nums, 2 * pos, start, mid);
        makeSegmentTree(nums, 2 * pos + 1, mid + 1, end);
        
        segment[pos] = segment[2 * pos] + segment[2 * pos + 1];
    }
    
    public void update(int index, int val) {
        updateHelper(1, 0, n - 1, index, val);
    }
    
    private void updateHelper(int pos, int start, int end, int idx, int val){
        if(start == end){
            segment[pos] = val;
            return;
        }
        
        int mid = start + (end - start) / 2;
        if(idx <= mid)
            updateHelper(2 * pos, start, mid, idx, val);
        else 
            updateHelper(2 * pos + 1, mid + 1, end, idx, val);
        segment[pos] = segment[2 * pos] + segment[2 * pos + 1]; 
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(1, 0, n - 1, left, right);
    }
    
    private int sumRangeHelper(int pos, int start, int end, int left, int right){
        if(left <= start && right >= end)
            return segment[pos];
        
        if(left > end || right < start)
            return 0;
        
        int mid = start + (end - start) / 2;
        int l = sumRangeHelper(2 * pos, start, mid, left, right);
        int r = sumRangeHelper(2 * pos + 1, mid + 1, end, left, right);
        return l + r;
    }
}