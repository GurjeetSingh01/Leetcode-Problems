class Solution {
 
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr); // find the peak index:  O(log n)
        int minIndex = findMinIndex(mountainArr, target, 0, peakIndex, true); // try to find the first index on left side: O(log n)
        if(minIndex != -1) return minIndex; // return the result if found
        minIndex = findMinIndex(mountainArr, target, peakIndex+1, mountainArr.length()-1, false); // try to find the first index on right side: O(log n)
        return minIndex;
    }
    
    // index of peak element
    public int findPeakIndex(MountainArray mountainArr){
        int low = 0;
        int high = mountainArr.length()-1;
        int mid;
        while(low < high){
            mid = low + (high - low) / 2;
            if(mid + 1 <=  high && mountainArr.get(mid) > mountainArr.get(mid + 1)) high = mid;
            else low = mid+1;
        }
        return low;
    }
    
    // find the minimum index position of a sorted array in increasing or decreasing order
    public int findMinIndex(MountainArray mountainArr, int target, int low, int high, boolean ascending){
        int mid;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(mountainArr.get(mid) == target){
                min = mid;
                high = mid-1;
            }else if(mountainArr.get(mid) > target){
                if(ascending) high = mid-1;
                else low = mid + 1;
            } 
            else{
                if(ascending) low  = mid+1;
                else high = mid - 1;
            } 
        }
        return min ==  Integer.MAX_VALUE ? -1: min;
    }
}
